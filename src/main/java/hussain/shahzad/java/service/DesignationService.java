package hussain.shahzad.java.service;
import hussain.shahzad.java.requests.dto.DesignationRequest;
import hussain.shahzad.java.responses.dto.DesignationResponse;
import java.util.List;
/**
 * @author shahzad.hussain
 */


public interface DesignationService{
	Long add(DesignationRequest request);
	DesignationResponse getById(Long id);
	List<DesignationResponse> getAll();
	void delete(Long id);
	boolean exist(Long id);
}