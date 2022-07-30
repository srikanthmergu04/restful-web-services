package com.java.rest.webservices.restfulwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.rest.webservices.restfulwebservices.exception.StudentNotFoundException;
import com.java.rest.webservices.restfulwebservices.model.Student;
import com.java.rest.webservices.restfulwebservices.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student user) {

		return studentRepository.save(user);

	}

	public Student getStudent(Integer id) {
		Student user = studentRepository.findById(id).orElse(null);

		if (user == null) {
			throw new StudentNotFoundException("id-" + id);
		}

		return user;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void deleteStudent(Integer id) {

		if (!studentRepository.existsById(id)) {
			throw new StudentNotFoundException("id-" + id);
		}

		studentRepository.deleteById(id);
	}

}
