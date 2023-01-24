package com.beginner.workshop.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beginner.workshop.models.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(null, "Bob", "bob@gmail.com", "213141", "2313544");
		return ResponseEntity.ok(user);
	}

}
