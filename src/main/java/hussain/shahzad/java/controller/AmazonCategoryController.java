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
import hussain.shahzad.java.requests.dto.AmazonCategoryRequest;
import hussain.shahzad.java.responses.dto.AmazonCategoryResponse;
import hussain.shahzad.java.responses.dto.Response;
import hussain.shahzad.java.service.AmazonCategoryService;

/**
 * @author shahzad.hussain
 */

@RestController
@RequestMapping(value = "/api/AmazonCategory")
public class AmazonCategoryController {

	@Autowired
	private AmazonCategoryService amazonCategoryService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Long> add(@RequestBody(required = true) AmazonCategoryRequest request) {
		Long response = amazonCategoryService.add(request);
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<AmazonCategoryResponse> getById(@PathVariable(RestMappingConstants.ID) Long id) {
		AmazonCategoryResponse response = amazonCategoryService.getById(id);
		if (response == null) {
			throw new MyAppException("AmazonCategory Not Found", HttpStatus.NOT_FOUND);
		}
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<AmazonCategoryResponse>> getAll() {
		List<AmazonCategoryResponse> response = amazonCategoryService.getAll();
		if (CollectionUtils.isEmpty(response)) {
			throw new MyAppException("No AmazonCategory Found", HttpStatus.NOT_FOUND);
		}
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
	}

	@DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id) {
		if (!amazonCategoryService.exist(id)) {
			throw new MyAppException("AmazonCategory Not Found", HttpStatus.NOT_FOUND);
		}
		amazonCategoryService.delete(id);
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), HttpStatus.OK);
	}

}