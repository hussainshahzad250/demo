package hussain.shahzad.java.service;
import hussain.shahzad.java.requests.dto.PersonRequest;
import hussain.shahzad.java.responses.dto.PersonResponse;
import java.util.List;

public interface PersonService{
	Long add(PersonRequest request);
	PersonResponse getById(Long id);
	List<PersonResponse> getAll();
	void delete(Long id);
	boolean exist(Long id);
}