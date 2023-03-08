package com.hussain.service.impl;

import com.hussain.converter.DesignationConverter;
import com.hussain.entity.Designation;
import com.hussain.repository.DesignationRepository;
import com.hussain.requests.DesignationRequest;
import com.hussain.responses.DesignationResponse;
import com.hussain.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author shahzad.hussain
 */


@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public Long add(DesignationRequest request) {
        Designation entity = DesignationConverter.getEntityFromRequest(request);
        if (entity != null) {
            designationRepository.save(entity);
            return entity.getId();
        }
        return 0l;
    }

    @Override
    public DesignationResponse getById(Long id) {
        Optional<Designation> optionalDesignation = designationRepository.findById(id);
        if (optionalDesignation.isPresent()) {
            return DesignationConverter.getResponseFromEntity(optionalDesignation.get());
        }
        return null;
    }

    @Override
    public List<DesignationResponse> getAll() {
        return DesignationConverter.getResponseListFromEntityList(designationRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        designationRepository.deleteById(id);
    }

    @Override
    public boolean exist(Long id) {
		return getById(id) != null;
	}

}