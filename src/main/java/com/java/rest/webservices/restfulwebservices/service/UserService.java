package com.java.rest.webservices.restfulwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.rest.webservices.restfulwebservices.model.User;
import com.java.rest.webservices.restfulwebservices.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {

		return userRepository.save(user);

	}

	public User getUser(Integer id) {
		return userRepository.findById(id).get();
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		;
	}

}
