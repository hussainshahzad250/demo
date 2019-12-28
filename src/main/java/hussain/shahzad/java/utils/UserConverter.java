package hussain.shahzad.java.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import hussain.shahzad.java.entity.User;
import hussain.shahzad.java.requests.dto.UserRequest;
import hussain.shahzad.java.responses.dto.UserResponse;

/**
 * @author shahzad.hussain
 */
@Component
public class UserConverter {

	public UserRequest getSample() {
		UserRequest response = new UserRequest();
		response.setFirstName("firstName");
		response.setLastName("lastName");
		response.setEmail("email");
		response.setMobile("mobile");
		return response;
	}

	public User getEntityFromRequest(UserRequest request) {
		if (request != null) {
			User response = new User();
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setEmail(request.getEmail());
			response.setMobile(request.getMobile());
			return response;
		}
		return null;
	}

	public static UserResponse getResponseFromEntity(User request) {
		if (request != null) {
			UserResponse response = new UserResponse();
			response.setUserId(request.getId());
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setEmail(request.getEmail());
			response.setMobile(request.getMobile());
			return response;
		}
		return null;
	}

	public User getEntityFromResponse(UserResponse request, User response) {
		if (request != null) {
			response.setFirstName(request.getFirstName());
			response.setLastName(request.getLastName());
			response.setEmail(request.getEmail());
			response.setMobile(request.getMobile());
			return response;
		}
		return response;
	}

	public static List<UserResponse> getResponseListFromEntityList(List<User> requestList) {
		if (CollectionUtils.isEmpty(requestList))
			return null;
		return requestList.parallelStream().map(request -> getResponseFromEntity(request)).collect(Collectors.toList());
	}
}