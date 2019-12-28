package hussain.shahzad.java.service;
import hussain.shahzad.java.requests.dto.UserRequest;
import hussain.shahzad.java.responses.dto.UserResponse;
import java.util.List;
/**
 * @author shahzad.hussain
 */


public interface UserService{
	Long add(UserRequest request);
	UserResponse getById(Long id);
	List<UserResponse> getAll();
	void delete(Long id);
	boolean exist(Long id);
}