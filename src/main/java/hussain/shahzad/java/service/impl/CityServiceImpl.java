package hussain.shahzad.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hussain.shahzad.java.entity.City;
import hussain.shahzad.java.requests.dto.CityRequest;
import hussain.shahzad.java.responses.dto.CityResponse;
import java.util.List;
import java.util.Optional;
import hussain.shahzad.java.service.CityService;
import hussain.shahzad.java.repository.CityRepository;
import hussain.shahzad.java.utils.CityConverter;

/**
 * @author shahzad.hussain
 */


@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;

	@Override
	public Long add(CityRequest request){
	City entity=CityConverter.getEntityFromRequest(request);
	if(entity!=null){
		cityRepository.save(entity);
		return entity.getId();
	}
	return 0l;
	}

	@Override
	public CityResponse getById(Long id){
		Optional<City> optionalCity=cityRepository.findById(id);
		if(optionalCity.isPresent()) {
			return CityConverter.getResponseFromEntity(optionalCity.get());
		}
		return null;
	}

	@Override
	public List<City> getAll(){
		return cityRepository.findAll();
//	return CityConverter.getResponseListFromEntityList(cityRepository.findAll());
	}

	@Override
	public void delete(Long id){
	cityRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id){
	if(getById(id)!=null){
		return true;
	}
	return false;
	}

}