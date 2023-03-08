package com.hussain.service;

import com.hussain.responses.DesignationResponse;
import com.hussain.requests.DesignationRequest;

import java.util.List;

public interface DesignationService {
    Long add(DesignationRequest request);

    DesignationResponse getById(Long id);

    List<DesignationResponse> getAll();

    void delete(Long id);

    boolean exist(Long id);
}