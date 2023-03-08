package com.hussain.service;

import com.hussain.requests.PersonRequest;
import com.hussain.responses.PersonResponse;

import java.util.List;

public interface PersonService {
    Long add(PersonRequest request);

    PersonResponse getById(Long id);

    List<PersonResponse> getAll();

    void delete(Long id);

    boolean exist(Long id);
}