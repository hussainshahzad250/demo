package hussain.shahzad.java.service;
import hussain.shahzad.java.requests.dto.EmployeeRequest;
import hussain.shahzad.java.responses.dto.EmployeeResponse;
import java.util.List;
/**
 * @author shahzad.hussain
 */


public interface EmployeeService{
	Long add(EmployeeRequest request);
	EmployeeResponse getById(Long id);
	List<EmployeeResponse> getAll();
	void delete(Long id);
	boolean exist(Long id);
}