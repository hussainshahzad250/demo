package hussain.shahzad.java.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import hussain.shahzad.java.entity.City;
import hussain.shahzad.java.requests.dto.CityRequest;
import hussain.shahzad.java.responses.dto.CityResponse;

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
		if (request != null) {
			City response = new City();
			if (!StringUtils.isEmpty(request.getName())) {
				response.setName(request.getName().replaceAll("[^a-zA-Z0-9_-[.] ]", "").replaceAll("( )+", " "));
			}
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static CityResponse getResponseFromEntity(City request) {
		if (request != null) {
			CityResponse response = new CityResponse();
			response.setCityId(request.getId());
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static City getEntityFromResponse(CityResponse request, City response) {
		if (request != null) {
			response.setName(request.getName());
			response.setPopulation(request.getPopulation());
			return response;
		}
		return null;
	}

	public static List<CityResponse> getResponseListFromEntityList(List<City> requestList) {
		if (CollectionUtils.isEmpty(requestList))
			return null;
		return requestList.stream().map(request -> getResponseFromEntity(request)).collect(Collectors.toList());
	}
}