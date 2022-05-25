package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.service.StudentService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@PostMapping("/api/savestudent")

	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentservice.saveStudent(student), HttpStatus.CREATED);
	}

	@GetMapping("/api/getAllStudent")
	public List<Student> getAllStudent() {
		return studentservice.getAllStudent();
	}

	@GetMapping("/api/getByStudentId/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		return new ResponseEntity<Student>(studentservice.getStudentById(id), HttpStatus.OK);
	}

	@PutMapping("/api/updateStudentById/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentservice.updateStudentById(student, id), HttpStatus.OK);
	}

	@DeleteMapping("/api/deleteStudentById/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id) {
		studentservice.deleteSById(id);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/api/getStudentByemail/{email}")
	public List<Student> getStudentByemail(@PathVariable String email) {
		return studentservice.findUserByEmail(email);
	}

	@GetMapping("/api/getStudentBymobile/{mobile}")
	public List<Student> getStudentBymobile(@PathVariable Long mobile) {
		return studentservice.findByMobile(mobile);
	}
}
