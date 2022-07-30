package com.java.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.webservices.restfulwebservices.model.User;
import com.java.rest.webservices.restfulwebservices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping()
	public User createUser(@RequestBody User user) {
		System.out.println(user.toString());
		return userService.saveUser(user);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@GetMapping()
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return "User Deleted";
	}

}
