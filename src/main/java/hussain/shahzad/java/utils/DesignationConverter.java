package hussain.shahzad.java.utils;

import hussain.shahzad.java.entity.Designation;
import java.util.ArrayList;
import org.springframework.util.CollectionUtils;
import java.util.List;
import hussain.shahzad.java.requests.dto.DesignationRequest;
import hussain.shahzad.java.responses.dto.DesignationResponse;

/**
 * @author shahzad.hussain
 */


public class DesignationConverter {

	public static DesignationRequest getSample() {
		DesignationRequest response = new DesignationRequest();
		response.setFirstName("firstName");
		response.setLastName("lastName");
		response.setSalary(123D);
		return response;
	}

	public static Designation getEntityFromRequest(DesignationRequest request) {
		if(request!=null){
			Designation response = new Designation();
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static DesignationResponse getResponseFromEntity(Designation request) {
		if(request!=null){
			DesignationResponse response = new DesignationResponse();
			response.setDesignationId(request.getId());
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static Designation getEntityFromResponse(DesignationResponse request,Designation response) {
		if(request!=null){
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static List<DesignationResponse> getResponseListFromEntityList(List<Designation> requestList) {
		if(CollectionUtils.isEmpty(requestList))
			return null;
		List<DesignationResponse> responseList = new ArrayList<>();
		for(Designation request:requestList){
			responseList.add(getResponseFromEntity(request));
		}
		return responseList;
	}
}