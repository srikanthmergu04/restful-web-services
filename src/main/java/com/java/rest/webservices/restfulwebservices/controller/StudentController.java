package com.java.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.rest.webservices.restfulwebservices.model.Student;
import com.java.rest.webservices.restfulwebservices.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping()
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
		System.out.println(student.toString());
		Student savedStudent = studentService.saveStudent(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{id}")
	public EntityModel<Student> getStudent(@PathVariable Integer id) {
		Student student = studentService.getStudent(id);
		EntityModel<Student> studentEntity = EntityModel.of(student);

		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getStudents());
		studentEntity.add(linkTo.withRel("all-students"));

		return studentEntity;
	}

	@GetMapping()
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		return "Student Deleted";
	}

}
