package com.tweteroo.tweterooapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweterooapi.DTO.UserDTO;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.repositories.UserRepository;
import com.tweteroo.tweterooapi.services.SignUpService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sign-up")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;

	@PostMapping
	public String createUser(@Valid @RequestBody UserDTO userDTO) {
		return signUpService.save(userDTO);
	}

	@GetMapping
	public List<User> getUsers() {
		return signUpService.findAll();
	}

}
