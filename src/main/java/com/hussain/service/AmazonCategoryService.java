package com.hussain.service;

import com.hussain.responses.AmazonCategoryResponse;
import com.hussain.requests.AmazonCategoryRequest;

import java.util.List;

public interface AmazonCategoryService {
    Long add(AmazonCategoryRequest request);

    AmazonCategoryResponse getById(Long id);

    List<AmazonCategoryResponse> getAll();

    void delete(Long id);

    boolean exist(Long id);
}