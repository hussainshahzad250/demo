package com.hussain.service;

import com.hussain.requests.EmployeeRequest;
import com.hussain.responses.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    Long add(EmployeeRequest request);

    EmployeeResponse getById(Long id);

    List<EmployeeResponse> getAll();

    void delete(Long id);

    boolean exist(Long id);
}