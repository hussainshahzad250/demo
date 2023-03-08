package com.hussain.converter;

import com.hussain.entity.Employee;
import com.hussain.requests.EmployeeRequest;
import com.hussain.responses.EmployeeResponse;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shahzad.hussain
 */


public class EmployeeConverter {

	public static EmployeeRequest getSample() {
		EmployeeRequest response = new EmployeeRequest();
		response.setName("name");
		response.setPopulation(4);
		return response;
	}

	public static Employee getEntityFromRequest(EmployeeRequest request) {
		if(request!=null){
			Employee response = new Employee();
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static EmployeeResponse getResponseFromEntity(Employee request) {
		if(request!=null){
			EmployeeResponse response = new EmployeeResponse();
			response.setEmployeeId(request.getId());
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static Employee getEntityFromResponse(EmployeeResponse request,Employee response) {
		if(request!=null){
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static List<EmployeeResponse> getResponseListFromEntityList(List<Employee> requestList) {
		if(CollectionUtils.isEmpty(requestList))
			return null;
		List<EmployeeResponse> responseList = new ArrayList<>();
		for(Employee request:requestList){
			responseList.add(getResponseFromEntity(request));
		}
		return responseList;
	}
}