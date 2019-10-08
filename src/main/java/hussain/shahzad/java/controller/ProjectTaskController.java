package hussain.shahzad.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import hussain.shahzad.java.requests.dto.ProjectTaskRequest;
import hussain.shahzad.java.responses.dto.ProjectTaskResponse;
import hussain.shahzad.java.responses.dto.Response;
import hussain.shahzad.java.service.ProjectTaskService;
import hussain.shahzad.java.utils.ProjectTaskConverter;

/**
 * @author shahzad.hussain
 */


@RestController
@RequestMapping(value = "/api/board")
@CrossOrigin
public class ProjectTaskController{

	@Autowired
	private ProjectTaskService projectTaskService;

	@GetMapping(value = RestMappingConstants.REQUEST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<ProjectTaskRequest> generateRequestJson() throws MyAppException{
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), ProjectTaskConverter.getSample(),
				HttpStatus.OK);
	}


	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Long> add(@RequestBody(required = true) ProjectTaskRequest request)throws MyAppException{
		Long response = projectTaskService.add(request);
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@GetMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<ProjectTaskResponse> getById(@PathVariable(RestMappingConstants.ID) Long id)throws MyAppException{
	ProjectTaskResponse response = projectTaskService.getById(id);
	if(response==null){
		throw new MyAppException("ProjectTask Not Found",HttpStatus.NOT_FOUND);
	}
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), response, HttpStatus.OK);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<ProjectTaskResponse>> getAll()throws MyAppException{
	List<ProjectTaskResponse> response = projectTaskService.getAll();
	if(CollectionUtils.isEmpty(response)){
		throw new MyAppException("No ProjectTask Found",HttpStatus.NOT_FOUND);
	}
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getCode(), response, HttpStatus.OK);
	}

	@DeleteMapping(path = RestMappingConstants.ID_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Boolean> delete(@PathVariable(RestMappingConstants.ID) Long id)throws MyAppException{
	if(!projectTaskService.exist(id)){
		throw new MyAppException("ProjectTask Not Found",HttpStatus.NOT_FOUND);
	}
	projectTaskService.delete(id);
		return new Response<>(LoanApplicationResponseCode.SUCCESS.getMessage(), HttpStatus.OK);
	}

}