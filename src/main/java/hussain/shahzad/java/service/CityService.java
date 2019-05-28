package hussain.shahzad.java.service;
import hussain.shahzad.java.entity.City;
import hussain.shahzad.java.requests.dto.CityRequest;
import hussain.shahzad.java.responses.dto.CityResponse;
import java.util.List;
/**
 * @author shahzad.hussain
 */


public interface CityService{
	Long add(CityRequest request);
	CityResponse getById(Long id);
	List<City> getAll();
	void delete(Long id);
	boolean exist(Long id);
}