package com.hussain.service;

import com.hussain.requests.CityRequest;
import com.hussain.entity.City;
import com.hussain.responses.CityResponse;

import java.util.List;

public interface CityService {
    Long add(CityRequest request);

    CityResponse getById(Long id);

    List<City> getAll();

    void delete(Long id);

    boolean exist(Long id);
}