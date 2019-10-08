package hussain.shahzad.java.service;
import hussain.shahzad.java.requests.dto.ProjectTaskRequest;
import hussain.shahzad.java.responses.dto.ProjectTaskResponse;
import java.util.List;
/**
 * @author shahzad.hussain
 */


public interface ProjectTaskService{
	Long add(ProjectTaskRequest request);
	ProjectTaskResponse getById(Long id);
	List<ProjectTaskResponse> getAll();
	void delete(Long id);
	boolean exist(Long id);
}