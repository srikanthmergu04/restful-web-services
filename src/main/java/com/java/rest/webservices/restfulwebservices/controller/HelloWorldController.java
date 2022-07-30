package com.java.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.webservices.restfulwebservices.model.Greeting;

@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String greeting() {
		return "Welcome";
	}

	@GetMapping("/hello-world/{name}")
	public Greeting greetingMsg(@PathVariable String name) {

		Greeting greetingmsg = new Greeting();
		greetingmsg.setMessage("Hello, " + name);
		return greetingmsg;
	}

}
