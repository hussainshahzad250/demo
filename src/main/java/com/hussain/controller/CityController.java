package com.hussain.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.constants.RestMappingConstants;
import com.hussain.entity.City;
import com.hussain.enums.LoanApplicationResponseCode;
import com.hussain.exception.MyAppException;
import com.hussain.requests.CityRequest;
import com.hussain.responses.CityResponse;
import com.hussain.responses.GeneratePdfReport;
import com.hussain.responses.Response;
import com.hussain.service.CityService;
import com.hussain.converter.CityConverter;

/**
 * @author shahzad.hussain
 */

@RestController
@RequestMapping(value = "/api/City")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = RestMappingConstants.REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CityRequest> generateRequestJson() throws MyAppException {
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), CityConverter.getSample(),
                HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Long> add(@RequestBody(required = true) CityRequest request) throws MyAppException {
        Long response = cityService.add(request);
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
    }

    @GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CityResponse> getById(@PathVariable(RestMappingConstants.ID) Long id) throws MyAppException {
        CityResponse response = cityService.getById(id);
        if (response == null) {
            throw new MyAppException("City Not Found", HttpStatus.NOT_FOUND);
        }
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
    }

    @DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id) throws MyAppException {
        if (!cityService.exist(id)) {
            throw new MyAppException("City Not Found", HttpStatus.NOT_FOUND);
        }
        cityService.delete(id);
        return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), HttpStatus.OK);
    }

    @GetMapping(value = "/pdfreport", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {
        List<City> cities = cityService.getAll();
        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}