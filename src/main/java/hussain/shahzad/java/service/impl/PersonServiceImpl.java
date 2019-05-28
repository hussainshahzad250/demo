package hussain.shahzad.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hussain.shahzad.java.entity.Person;
import hussain.shahzad.java.requests.dto.PersonRequest;
import hussain.shahzad.java.responses.dto.PersonResponse;
import java.util.List;
import java.util.Optional;
import hussain.shahzad.java.service.PersonService;
import hussain.shahzad.java.repository.PersonRepository;
import hussain.shahzad.java.utils.PersonConverter;

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
		if (byId == null) {
			return false;
		}
		return true;
	}

}