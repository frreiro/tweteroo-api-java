package com.tweteroo.tweterooapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweterooapi.DTO.UserDTO;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.repositories.UserRepository;

@Service
public class SignUpService {

	@Autowired
	private UserRepository userRepository;

	public String save(UserDTO userDTO) {

		User userDB = userRepository.findByUsername(userDTO.username());
		if (userDB != null) {

			// TODO: retornar status code correto
			return "User already exists";
		}
		User user = new User(userDTO);
		userRepository.save(user);
		return "OK";
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
