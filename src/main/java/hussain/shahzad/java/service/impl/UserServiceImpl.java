package hussain.shahzad.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hussain.shahzad.java.entity.User;
import hussain.shahzad.java.repository.UserRepository;
import hussain.shahzad.java.requests.dto.UserRequest;
import hussain.shahzad.java.responses.dto.UserResponse;
import hussain.shahzad.java.service.UserService;
import hussain.shahzad.java.utils.UserConverter;

/**
 * @author shahzad.hussain
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public Long add(UserRequest request) {
		User entity = userConverter.getEntityFromRequest(request);
		if (entity != null) {
			userRepository.save(entity);
			return entity.getId();
		}
		return 0l;
	}

	@Override
	public UserResponse getById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return UserConverter.getResponseFromEntity(optionalUser.get());
		}
		return null;
	}

	@Override
	public List<UserResponse> getAll() {
		return UserConverter.getResponseListFromEntityList(userRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public boolean exist(Long id) {
		if (getById(id) != null) {
			return true;
		}
		return false;
	}

}