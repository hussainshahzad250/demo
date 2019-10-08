package hussain.shahzad.java.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import hussain.shahzad.java.entity.Person;
import hussain.shahzad.java.requests.dto.PersonRequest;
import hussain.shahzad.java.requests.dto.RetailerRequest;
import hussain.shahzad.java.responses.dto.ExcellResponse;
import hussain.shahzad.java.responses.dto.PersonResponse;

public class PersonConverter {

	public static PersonRequest getSample() {
		PersonRequest response = new PersonRequest();
		response.setFirstName("firstName");
		response.setLastName("lastName");
		response.setSalary(123D);
		return response;
	}

	public static Person getEntityFromRequest(PersonRequest request) {
		if (request != null) {
			Person response = new Person();
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static PersonResponse getResponseFromEntity(Person request) {
		if (request != null) {
			PersonResponse response = new PersonResponse();
			response.setPersonId(request.getId());
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static Person getEntityFromResponse(PersonResponse request, Person response) {
		if (request != null) {
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static List<PersonResponse> getResponseListFromEntityList(List<Person> requestList) {
		if (CollectionUtils.isEmpty(requestList))
			return null;
		return requestList.stream().map(request -> getResponseFromEntity(request)).collect(Collectors.toList());
	}

	public static List<ExcellResponse> chnageResponse(List<RetailerRequest> retailers) {
		return retailers.stream().map(request -> toObject(request)).collect(Collectors.toList());
	}

	private static ExcellResponse toObject(RetailerRequest request) {
		ExcellResponse response = new ExcellResponse();
		response.setCity(request.getCity());
		response.setCountry(request.getCountry());
		response.setGender(request.getGender());
		response.setCurrency(request.getCurrency());
		response.setBalance(Integer.parseInt(request.getBalance()));
		response.setMobile(request.getMobile());
		response.setEmail(request.getEmail());
		return response;

	}

}