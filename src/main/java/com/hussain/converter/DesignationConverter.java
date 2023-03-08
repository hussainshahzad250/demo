package com.hussain.converter;

import com.hussain.entity.Designation;
import com.hussain.requests.DesignationRequest;
import com.hussain.responses.DesignationResponse;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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