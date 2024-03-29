package com.hussain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hussain.constants.RestMappingConstants;
import com.hussain.enums.LoanApplicationResponseCode;
import com.hussain.exception.MyAppException;
import com.hussain.responses.Response;
import org.springframework.util.CollectionUtils;
import com.hussain.requests.EmployeeRequest;
import com.hussain.responses.EmployeeResponse;

import java.util.List;

import com.hussain.service.EmployeeService;
import com.hussain.converter.EmployeeConverter;

/**
 * @author shahzad.hussain
 */


@RestController
@RequestMapping(value = "/api/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = RestMappingConstants.REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<EmployeeRequest> generateRequestJson() throws MyAppException {
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), EmployeeConverter.getSample(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Long> add(@RequestBody(required = true) EmployeeRequest request) throws MyAppException {
        Long response = employeeService.add(request);
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
    }

    @GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<EmployeeResponse> getById(@PathVariable(RestMappingConstants.ID) Long id) throws MyAppException {
        EmployeeResponse response = employeeService.getById(id);
        if (response == null) {
            throw new MyAppException("Employee Not Found", HttpStatus.NOT_FOUND);
        }
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<EmployeeResponse>> getAll() throws MyAppException {
        List<EmployeeResponse> response = employeeService.getAll();
        if (CollectionUtils.isEmpty(response)) {
            throw new MyAppException("No Employee Found", HttpStatus.NOT_FOUND);
        }
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
    }

    @DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id) throws MyAppException {
        if (!employeeService.exist(id)) {
            throw new MyAppException("Employee Not Found", HttpStatus.NOT_FOUND);
        }
        employeeService.delete(id);
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), HttpStatus.OK);
    }

}