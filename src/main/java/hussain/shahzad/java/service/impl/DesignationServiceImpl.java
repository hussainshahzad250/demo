package hussain.shahzad.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hussain.shahzad.java.entity.Designation;
import hussain.shahzad.java.requests.dto.DesignationRequest;
import hussain.shahzad.java.responses.dto.DesignationResponse;
import java.util.List;
import java.util.Optional;
import hussain.shahzad.java.service.DesignationService;
import hussain.shahzad.java.repository.DesignationRepository;
import hussain.shahzad.java.utils.DesignationConverter;

/**
 * @author shahzad.hussain
 */


@Service
public class DesignationServiceImpl implements DesignationService{

	@Autowired
	private DesignationRepository designationRepository;

	@Override
	public Long add(DesignationRequest request){
	Designation entity=DesignationConverter.getEntityFromRequest(request);
	if(entity!=null){
		designationRepository.save(entity);
		return entity.getId();
	}
	return 0l;
	}

	@Override
	public DesignationResponse getById(Long id){
		Optional<Designation> optionalDesignation=designationRepository.findById(id);
		if(optionalDesignation.isPresent()) {
			return DesignationConverter.getResponseFromEntity(optionalDesignation.get());
		}
		return null;
	}

	@Override
	public List<DesignationResponse> getAll(){
	return DesignationConverter.getResponseListFromEntityList(designationRepository.findAll());
	}

	@Override
	public void delete(Long id){
	designationRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id){
	if(getById(id)!=null){
		return true;
	}
	return false;
	}

}