package com.tweteroo.tweterooapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweterooapi.DTO.UserDTO;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.repositories.UserRepository;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public String createUser(@RequestBody UserDTO userDTO) {
		User user = new User(userDTO);
		userRepository.save(user);
		return "OK";
	}

	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
