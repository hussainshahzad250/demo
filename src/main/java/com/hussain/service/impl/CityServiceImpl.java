package com.hussain.service.impl;

import com.hussain.converter.CityConverter;
import com.hussain.entity.City;
import com.hussain.repository.CityRepository;
import com.hussain.requests.CityRequest;
import com.hussain.responses.CityResponse;
import com.hussain.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Long add(CityRequest request) {
        City entity = CityConverter.getEntityFromRequest(request);
        if (entity != null) {
            cityRepository.save(entity);
            return entity.getId();
        }
        return 0l;
    }

    @Override
    public CityResponse getById(Long id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            return CityConverter.getResponseFromEntity(optionalCity.get());
        }
        return null;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
//	return CityConverter.getResponseListFromEntityList(cityRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public boolean exist(Long id) {
		return getById(id) != null;
	}

}