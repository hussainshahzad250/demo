package com.hussain.converter;

import com.hussain.entity.City;
import com.hussain.requests.CityRequest;
import com.hussain.responses.CityResponse;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shahzad.hussain
 */


public class CityConverter {

	public static CityRequest getSample() {
		CityRequest response = new CityRequest();
		response.setName("name");
		response.setPopulation(1000);
		return response;
	}

	public static City getEntityFromRequest(CityRequest request) {
		if(request!=null){
			City response = new City();
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static CityResponse getResponseFromEntity(City request) {
		if(request!=null){
			CityResponse response = new CityResponse();
			response.setCityId(request.getId());
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static City getEntityFromResponse(CityResponse request,City response) {
		if(request!=null){
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static List<CityResponse> getResponseListFromEntityList(List<City> requestList) {
		if(CollectionUtils.isEmpty(requestList))
			return null;
		List<CityResponse> responseList = new ArrayList<>();
		for(City request:requestList){
			responseList.add(getResponseFromEntity(request));
		}
		return responseList;
	}
}