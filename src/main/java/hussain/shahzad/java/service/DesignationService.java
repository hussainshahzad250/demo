package hussain.shahzad.java.service;

import java.util.List;

import hussain.shahzad.java.requests.dto.DesignationRequest;
import hussain.shahzad.java.responses.dto.DesignationResponse;

/**
 * @author shahzad.hussain
 */

public interface DesignationService {
	Long add(DesignationRequest request);

	DesignationResponse getById(Long id);

	List<DesignationResponse> getAll();

	void delete(Long id);

	boolean exist(Long id);

}