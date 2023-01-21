package com.tweteroo.tweterooapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweterooapi.DTO.UserDTO;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.services.SignUpService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sign-up")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;

	@PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(signUpService.save(userDTO));
	}

}
