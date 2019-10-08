package hussain.shahzad.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hussain.shahzad.java.constants.RestMappingConstants;
import hussain.shahzad.java.enums.LoanApplicationResponseCode;
import hussain.shahzad.java.exception.MyAppException;
import hussain.shahzad.java.requests.dto.DesignationRequest;
import hussain.shahzad.java.responses.dto.DesignationResponse;
import hussain.shahzad.java.responses.dto.Response;
import hussain.shahzad.java.service.DesignationService;
import hussain.shahzad.java.utils.DesignationConverter;

/**
 * @author shahzad.hussain
 */

@RestController
@RequestMapping(value = "/api/Designation")
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@GetMapping(value = RestMappingConstants.REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<DesignationRequest> generateRequestJson() {
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), DesignationConverter.getSample(),
				HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Long> add(@RequestBody(required = true) DesignationRequest request) {
		Long response = designationService.add(request);
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<DesignationResponse> getById(@PathVariable(RestMappingConstants.ID) Long id) {
		DesignationResponse response = designationService.getById(id);
		if (response == null) {
			throw new MyAppException("Designation Not Found", HttpStatus.NOT_FOUND);
		}
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<DesignationResponse>> getAll() {
		List<DesignationResponse> response = designationService.getAll();
		if (CollectionUtils.isEmpty(response)) {
			throw new MyAppException("No Designation Found", HttpStatus.NOT_FOUND);
		}
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
	}

	@DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id) {
		if (!designationService.exist(id)) {
			throw new MyAppException("Designation Not Found", HttpStatus.NOT_FOUND);
		}
		designationService.delete(id);
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), HttpStatus.OK);
	}

}