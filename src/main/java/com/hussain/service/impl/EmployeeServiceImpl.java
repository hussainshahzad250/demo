package com.hussain.service.impl;

import com.hussain.converter.EmployeeConverter;
import com.hussain.entity.Employee;
import com.hussain.repository.EmployeeRepository;
import com.hussain.requests.EmployeeRequest;
import com.hussain.responses.EmployeeResponse;
import com.hussain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author shahzad.hussain
 */


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Long add(EmployeeRequest request) {
        Employee entity = EmployeeConverter.getEntityFromRequest(request);
        if (entity != null) {
            employeeRepository.save(entity);
            return entity.getId();
        }
        return 0l;
    }

    @Override
    public EmployeeResponse getById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return EmployeeConverter.getResponseFromEntity(optionalEmployee.get());
        }
        return null;
    }

    @Override
    public List<EmployeeResponse> getAll() {
        return EmployeeConverter.getResponseListFromEntityList(employeeRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public boolean exist(Long id) {
		return getById(id) != null;
	}

}