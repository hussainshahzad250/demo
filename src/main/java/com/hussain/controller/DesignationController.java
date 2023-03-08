package com.hussain.controller;

import com.hussain.responses.DesignationResponse;
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
import com.hussain.requests.DesignationRequest;

import java.util.List;
import com.hussain.service.DesignationService;
import com.hussain.converter.DesignationConverter;

/**
 * @author shahzad.hussain
 */


@RestController
@RequestMapping(value = "/api/Designation")
public class DesignationController{

	@Autowired
	private DesignationService designationService;

	@GetMapping(value = RestMappingConstants.REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<DesignationRequest> generateRequestJson() throws MyAppException{
		return new Response<DesignationRequest>(LoanApplicationResponseCode.SUCCESS.getMessage(),DesignationConverter.getSample(),HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Long> add(@RequestBody(required = true) DesignationRequest request)throws MyAppException{
		Long response = designationService.add(request);
		return new Response<Long>(LoanApplicationResponseCode.SUCCESS.getMessage(),response,HttpStatus.OK);
	}

	@GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<DesignationResponse> getById(@PathVariable(RestMappingConstants.ID) Long id)throws MyAppException{
	DesignationResponse response = designationService.getById(id);
	if(response==null){
		throw new MyAppException("Designation Not Found",HttpStatus.NOT_FOUND);
	}
	return new Response<DesignationResponse>(LoanApplicationResponseCode.SUCCESS.getMessage(),response,HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<DesignationResponse>> getAll()throws MyAppException{
	List<DesignationResponse> response = designationService.getAll();
	if(CollectionUtils.isEmpty(response)){
		throw new MyAppException("No Designation Found",HttpStatus.NOT_FOUND);
	}
	return new Response<List<DesignationResponse>>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
	}

	@DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id)throws MyAppException{
	if(!designationService.exist(id)){
		throw new MyAppException("Designation Not Found",HttpStatus.NOT_FOUND);
	}
	designationService.delete(id);
	return new Response<Boolean>(LoanApplicationResponseCode.SUCCESS.getMessage(),HttpStatus.OK);
	}

}