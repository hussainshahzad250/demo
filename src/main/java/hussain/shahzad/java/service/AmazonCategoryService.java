package hussain.shahzad.java.service;
import hussain.shahzad.java.requests.dto.AmazonCategoryRequest;
import hussain.shahzad.java.responses.dto.AmazonCategoryResponse;
import java.util.List;
/**
 * @author shahzad.hussain
 */


public interface AmazonCategoryService{
	Long add(AmazonCategoryRequest request);
	AmazonCategoryResponse getById(Long id);
	List<AmazonCategoryResponse> getAll();
	void delete(Long id);
	boolean exist(Long id);
}