package hussain.shahzad.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hussain.shahzad.java.constants.RestMappingConstants;
import hussain.shahzad.java.enums.LoanApplicationResponseCode;
import hussain.shahzad.java.exception.MyAppException;
import hussain.shahzad.java.requests.dto.PersonRequest;
import hussain.shahzad.java.responses.dto.PersonResponse;
import hussain.shahzad.java.responses.dto.Response;
import hussain.shahzad.java.service.PersonService;
import hussain.shahzad.java.utils.PersonConverter;

@Controller
@RequestMapping(value = "/api/Person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = RestMappingConstants.REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response<PersonRequest> generateRequestJson(HttpServletRequest request) throws MyAppException {

		String remoteAddr = request.getHeader("VIA");
		System.out.println("VIA Gateway IP1 " + remoteAddr);
		remoteAddr = request.getHeader("X-FORWARDED-FOR");
		System.out.println("FORWARDED IP2 " + remoteAddr);

		System.out.println("REmote Address " + request.getRemoteAddr());
		System.out.println("Local Adrd" + request.getLocalAddr());
		System.out.println("" + request.getParameterNames());
		remoteAddr = request.getHeader("REMOTE_ADDR");
		System.out.println("REMOTE_ADDR Header IP3 " + remoteAddr);
		return new Response<PersonRequest>(LoanApplicationResponseCode.SUCCESS.getMessage(),
				PersonConverter.getSample(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response<Long> add(@RequestBody(required = true) PersonRequest request) throws MyAppException {
		Long response = personService.add(request);
		return new Response<Long>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@RequestMapping(path = RestMappingConstants.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response<PersonResponse> getById(@PathVariable(RestMappingConstants.ID) Long id) throws MyAppException {
		PersonResponse response = personService.getById(id);
		if (response == null) {
			throw new MyAppException(LoanApplicationResponseCode.PERSON_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new Response<PersonResponse>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response<List<PersonResponse>> getAll() throws MyAppException {
		List<PersonResponse> response = personService.getAll();
		if (CollectionUtils.isEmpty(response)) {
			throw new MyAppException(LoanApplicationResponseCode.PERSON_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new Response<List<PersonResponse>>(LoanApplicationResponseCode.SUCCESS.getCode(), response,
				HttpStatus.OK);
	}

	@RequestMapping(path = RestMappingConstants.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id) throws MyAppException {
		if (!personService.exist(id)) {
			throw new MyAppException(LoanApplicationResponseCode.PERSON_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
		}
		personService.delete(id);
		return new Response<Boolean>(LoanApplicationResponseCode.SUCCESS.getMessage(), HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public Response<Boolean> update(@RequestBody(required = true) PersonResponse request) throws MyAppException {
//		if (!personService.exist(request.getPersonId())) {
//			throw new MyAppException(LoanApplicationResponseCode.PERSON_NOT_FOUND, HttpStatus.NOT_FOUND);
//		}
//		Boolean response = personService.update(request);
//		return new Response<Boolean>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
//	}

}