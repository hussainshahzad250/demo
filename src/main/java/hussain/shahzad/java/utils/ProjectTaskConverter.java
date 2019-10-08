package hussain.shahzad.java.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import hussain.shahzad.java.entity.ProjectTask;
import hussain.shahzad.java.requests.dto.ProjectTaskRequest;
import hussain.shahzad.java.responses.dto.ProjectTaskResponse;

/**
 * @author shahzad.hussain
 */


public class ProjectTaskConverter {

	public static ProjectTaskRequest getSample() {
		ProjectTaskRequest response = new ProjectTaskRequest();
		response.setSummary("summary");
		response.setAcceptanceCriteria("acceptanceCriteria");
		response.setStatus("status");
		return response;
	}

	public static ProjectTask getEntityFromRequest(ProjectTaskRequest request) {
		if(request!=null){
			ProjectTask response = new ProjectTask();
			response.setSummary(request.getSummary());
			response.setAcceptanceCriteria(request.getAcceptanceCriteria());
			response.setStatus(request.getStatus());
			return response;
		}
		return null;
	}

	public static ProjectTaskResponse getResponseFromEntity(ProjectTask request) {
		if(request!=null){
			ProjectTaskResponse response = new ProjectTaskResponse();
			response.setId(request.getId());
			response.setSummary(request.getSummary());
			response.setAcceptanceCriteria(request.getAcceptanceCriteria());
			response.setStatus(request.getStatus());
			return response;
		}
		return null;
	}

	public static ProjectTask getEntityFromResponse(ProjectTaskResponse request,ProjectTask response) {
		if(request!=null){
			response.setSummary(request.getSummary());
			response.setAcceptanceCriteria(request.getAcceptanceCriteria());
			response.setStatus(request.getStatus());
			return response;
		}
		return null;
	}

	public static List<ProjectTaskResponse> getResponseListFromEntityList(List<ProjectTask> requestList) {
		if(CollectionUtils.isEmpty(requestList))
			return null;
		List<ProjectTaskResponse> responseList = new ArrayList<>();
		for(ProjectTask request:requestList){
			responseList.add(getResponseFromEntity(request));
		}
		return responseList;
	}
}