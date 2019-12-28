package hussain.shahzad.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hussain.shahzad.java.constants.Constants;
import hussain.shahzad.java.enums.ResponseCode;
import hussain.shahzad.java.exception.MyAppException;
import hussain.shahzad.java.requests.dto.UserRequest;
import hussain.shahzad.java.responses.dto.Response;
import hussain.shahzad.java.responses.dto.UserResponse;
import hussain.shahzad.java.service.UserService;
import hussain.shahzad.java.utils.UserConverter;
import hussain.shahzad.java.utils.ValidationUtils;

/**
 * @author shahzad.hussain
 */

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;

	@GetMapping(value = Constants.REQUEST)
	public Response<UserRequest> generateRequestJson() throws MyAppException {
		return new Response<>(ResponseCode.SUCCESS.getMessage(), userConverter.getSample(), HttpStatus.OK);
	}

	@PostMapping
	public Response<Long> add(@RequestBody(required = true) UserRequest request) throws MyAppException {
		ValidationUtils.validateRequest(request);
		Long response = userService.add(request);
		return new Response<>(ResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@GetMapping
	public Response<List<UserResponse>> getAll() throws MyAppException {
		List<UserResponse> response = userService.getAll();
		if (CollectionUtils.isEmpty(response))
			throw new MyAppException("No User Found", HttpStatus.NOT_FOUND);
		return new Response<>(ResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
	}

}