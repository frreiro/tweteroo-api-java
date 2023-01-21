package com.tweteroo.tweterooapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tweteroo.tweterooapi.DTO.UserDTO;
import com.tweteroo.tweterooapi.exceptions.ConflictException;
import com.tweteroo.tweterooapi.exceptions.NotFoundException;
import com.tweteroo.tweterooapi.handler.RestResponseEntityExceptionHandler;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.repositories.UserRepository;

@Service
public class SignUpService {

	@Autowired
	private UserRepository userRepository;

	public String save(UserDTO userDTO) {

		User userDB = userRepository.findByUsername(userDTO.username());
		if (userDB != null) {

			throw new ConflictException();
		}
		User user = new User(userDTO);
		userRepository.save(user);
		return "OK";
	}
}
