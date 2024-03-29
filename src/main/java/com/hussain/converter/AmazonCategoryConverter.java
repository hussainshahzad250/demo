package com.hussain.converter;

import com.hussain.entity.AmazonCategory;
import com.hussain.requests.AmazonCategoryRequest;
import com.hussain.responses.AmazonCategoryResponse;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
		List<AmazonCategoryResponse> responseList = new ArrayList<>();
		for (AmazonCategory request : requestList) {
			responseList.add(getResponseFromEntity(request));
		}
		return responseList;
	}
}