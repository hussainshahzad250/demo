package hussain.shahzad.java.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import hussain.shahzad.java.entity.AmazonCategory;
import hussain.shahzad.java.requests.dto.AmazonCategoryRequest;
import hussain.shahzad.java.responses.dto.AmazonCategoryResponse;

/**
 * @author shahzad.hussain
 */

public class AmazonCategoryConverter {

	public static AmazonCategoryRequest getSample() {
		AmazonCategoryRequest response = new AmazonCategoryRequest();
		response.setId("id");
		response.setName("name");
		response.setUrl("url");
		response.setDescription("description");
		response.setSubcategoriesCount(123);
		return response;
	}

	public static AmazonCategory getEntityFromRequest(AmazonCategoryRequest request) {
		if (request != null) {
			AmazonCategory response = new AmazonCategory();
			response.setId(Long.valueOf(request.getId()));
			response.setName(request.getName());
			response.setUrl(request.getUrl());
			response.setDescription(request.getDescription());
			response.setSubcategoriesCount(request.getSubcategoriesCount());
			return response;
		}
		return null;
	}

	public static AmazonCategoryResponse getResponseFromEntity(AmazonCategory request) {
		if (request != null) {
			AmazonCategoryResponse response = new AmazonCategoryResponse();
			response.setAmazonCategoryId(request.getId());
			response.setId(String.valueOf(request.getId()));
			response.setName(request.getName());
			response.setUrl(request.getUrl());
			response.setDescription(request.getDescription());
			response.setSubcategoriesCount(request.getSubcategoriesCount());
			return response;
		}
		return null;
	}

	public static AmazonCategory getEntityFromResponse(AmazonCategoryResponse request, AmazonCategory response) {
		if (request != null) {
			response.setId(Long.valueOf(request.getId()));
			response.setName(request.getName());
			response.setUrl(request.getUrl());
			response.setDescription(request.getDescription());
			response.setSubcategoriesCount(request.getSubcategoriesCount());
			return response;
		}
		return null;
	}

	public static List<AmazonCategoryResponse> getResponseListFromEntityList(List<AmazonCategory> requestList) {
		if (CollectionUtils.isEmpty(requestList))
			return null;
		return requestList.stream().map(request -> getResponseFromEntity(request)).collect(Collectors.toList());
	}
}