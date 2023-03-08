package com.hussain.controller;

import com.hussain.constants.RestMappingConstants;
import com.hussain.enums.LoanApplicationResponseCode;
import com.hussain.exception.MyAppException;
import com.hussain.requests.AmazonCategoryRequest;
import com.hussain.responses.AmazonCategoryResponse;
import com.hussain.responses.Response;
import com.hussain.service.AmazonCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shahzad.hussain
 */

@RestController
@RequestMapping(value = "/api/amazonCategory")
public class AmazonCategoryController {

    @Autowired
    private AmazonCategoryService amazonCategoryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Long> add(@RequestBody(required = true) AmazonCategoryRequest request) throws MyAppException {
        Long response = amazonCategoryService.add(request);
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
    }

    @GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<AmazonCategoryResponse> getById(@PathVariable(RestMappingConstants.ID) Long id)
            throws MyAppException {
        AmazonCategoryResponse response = amazonCategoryService.getById(id);
        if (response == null) {
            throw new MyAppException("AmazonCategory Not Found", HttpStatus.NOT_FOUND);
        }
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response,
                HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<AmazonCategoryResponse>> getAll() throws MyAppException {
        List<AmazonCategoryResponse> response = amazonCategoryService.getAll();
        if (CollectionUtils.isEmpty(response)) {
            throw new MyAppException("No AmazonCategory Found", HttpStatus.NOT_FOUND);
        }
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getCode(), response,
                HttpStatus.OK);
    }

    @DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id) throws MyAppException {
        if (!amazonCategoryService.exist(id)) {
            throw new MyAppException("AmazonCategory Not Found", HttpStatus.NOT_FOUND);
        }
        amazonCategoryService.delete(id);
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), HttpStatus.OK);
    }

}