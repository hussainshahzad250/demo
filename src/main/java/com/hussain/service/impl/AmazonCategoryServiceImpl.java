package com.hussain.service.impl;

import com.hussain.converter.AmazonCategoryConverter;
import com.hussain.entity.AmazonCategory;
import com.hussain.repository.AmazonCategoryRepository;
import com.hussain.requests.AmazonCategoryRequest;
import com.hussain.responses.AmazonCategoryResponse;
import com.hussain.service.AmazonCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmazonCategoryServiceImpl implements AmazonCategoryService {

    @Autowired
    private AmazonCategoryRepository amazonCategoryRepository;

    @Override
    public Long add(AmazonCategoryRequest request) {
        AmazonCategory entity = AmazonCategoryConverter.getEntityFromRequest(request);
        if (entity != null) {
            amazonCategoryRepository.save(entity);
            return entity.getId();
        }
        return 0l;
    }

    @Override
    public AmazonCategoryResponse getById(Long id) {
        Optional<AmazonCategory> optionalAmazonCategory = amazonCategoryRepository.findById(id);
        if (optionalAmazonCategory.isPresent()) {
            return AmazonCategoryConverter.getResponseFromEntity(optionalAmazonCategory.get());
        }
        return null;
    }

    @Override
    public List<AmazonCategoryResponse> getAll() {
        return AmazonCategoryConverter.getResponseListFromEntityList(amazonCategoryRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        amazonCategoryRepository.deleteById(id);
    }

    @Override
    public boolean exist(Long id) {
		return getById(id) != null;
	}

}