package hussain.shahzad.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hussain.shahzad.java.entity.ProjectTask;
import hussain.shahzad.java.requests.dto.ProjectTaskRequest;
import hussain.shahzad.java.responses.dto.ProjectTaskResponse;
import java.util.List;
import java.util.Optional;
import hussain.shahzad.java.service.ProjectTaskService;
import hussain.shahzad.java.repository.ProjectTaskRepository;
import hussain.shahzad.java.utils.ProjectTaskConverter;

/**
 * @author shahzad.hussain
 */


@Service
public class ProjectTaskServiceImpl implements ProjectTaskService{

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	@Override
	public Long add(ProjectTaskRequest request){
	ProjectTask entity=ProjectTaskConverter.getEntityFromRequest(request);
	if(entity!=null){
		projectTaskRepository.save(entity);
		return entity.getId();
	}
	return 0l;
	}

	@Override
	public ProjectTaskResponse getById(Long id){
		Optional<ProjectTask> optionalProjectTask=projectTaskRepository.findById(id);
		if(optionalProjectTask.isPresent()) {
			return ProjectTaskConverter.getResponseFromEntity(optionalProjectTask.get());
		}
		return null;
	}

	@Override
	public List<ProjectTaskResponse> getAll(){
	return ProjectTaskConverter.getResponseListFromEntityList(projectTaskRepository.findAll());
	}

	@Override
	public void delete(Long id){
	projectTaskRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id){
	if(getById(id)!=null){
		return true;
	}
	return false;
	}

}