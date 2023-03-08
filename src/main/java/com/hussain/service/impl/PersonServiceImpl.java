package com.hussain.service.impl;

import com.hussain.converter.PersonConverter;
import com.hussain.entity.Person;
import com.hussain.repository.PersonRepository;
import com.hussain.requests.PersonRequest;
import com.hussain.responses.PersonResponse;
import com.hussain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Long add(PersonRequest request) {
        Person entity = PersonConverter.getEntityFromRequest(request);
        if (entity != null) {
            personRepository.save(entity);
            return entity.getId();
        }
        return 0l;
    }

    @Override
    public PersonResponse getById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return PersonConverter.getResponseFromEntity(optionalPerson.get());
        }
        return null;
    }

    @Override
    public List<PersonResponse> getAll() {
        return PersonConverter.getResponseListFromEntityList(personRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public boolean exist(Long id) {
        PersonResponse byId = getById(id);
		return byId != null;
	}

}