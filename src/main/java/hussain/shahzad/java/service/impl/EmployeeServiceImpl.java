package hussain.shahzad.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hussain.shahzad.java.entity.Employee;
import hussain.shahzad.java.requests.dto.EmployeeRequest;
import hussain.shahzad.java.responses.dto.EmployeeResponse;
import java.util.List;
import java.util.Optional;
import hussain.shahzad.java.service.EmployeeService;
import hussain.shahzad.java.repository.EmployeeRepository;
import hussain.shahzad.java.utils.EmployeeConverter;

/**
 * @author shahzad.hussain
 */


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Long add(EmployeeRequest request){
	Employee entity=EmployeeConverter.getEntityFromRequest(request);
	if(entity!=null){
		employeeRepository.save(entity);
		return entity.getId();
	}
	return 0l;
	}

	@Override
	public EmployeeResponse getById(Long id){
		Optional<Employee> optionalEmployee=employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			return EmployeeConverter.getResponseFromEntity(optionalEmployee.get());
		}
		return null;
	}

	@Override
	public List<EmployeeResponse> getAll(){
	return EmployeeConverter.getResponseListFromEntityList(employeeRepository.findAll());
	}

	@Override
	public void delete(Long id){
	employeeRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id){
	if(getById(id)!=null){
		return true;
	}
	return false;
	}

}