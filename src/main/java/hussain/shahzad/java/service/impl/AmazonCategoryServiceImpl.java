package hussain.shahzad.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hussain.shahzad.java.entity.AmazonCategory;
import hussain.shahzad.java.repository.AmazonCategoryRepository;
import hussain.shahzad.java.requests.dto.AmazonCategoryRequest;
import hussain.shahzad.java.responses.dto.AmazonCategoryResponse;
import hussain.shahzad.java.service.AmazonCategoryService;
import hussain.shahzad.java.utils.AmazonCategoryConverter;

/**
 * @author shahzad.hussain
 */

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
		if (getById(id) != null) {
			return true;
		}
		return false;
	}

}