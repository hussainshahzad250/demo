package hussain.shahzad.java.utils;

import hussain.shahzad.java.entity.Person;
import java.util.ArrayList;
import org.springframework.util.CollectionUtils;
import java.util.List;
import hussain.shahzad.java.requests.dto.PersonRequest;
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
		if(request!=null){
			Person response = new Person();
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static PersonResponse getResponseFromEntity(Person request) {
		if(request!=null){
			PersonResponse response = new PersonResponse();
			response.setPersonId(request.getId());
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static Person getEntityFromResponse(PersonResponse request,Person response) {
		if(request!=null){
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setSalary(request.getSalary());
			return response;
		}
		return null;
	}

	public static List<PersonResponse> getResponseListFromEntityList(List<Person> requestList) {
		if(CollectionUtils.isEmpty(requestList))
			return null;
		List<PersonResponse> responseList = new ArrayList<>();
		for(Person request:requestList){
			responseList.add(getResponseFromEntity(request));
		}
		return responseList;
	}
}