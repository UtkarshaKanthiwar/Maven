package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exception.StudentNotFoundException;
import com.model.Course;
import com.model.Student;
import com.repository.StudentRepository;
import com.service.CourseService;

@RestController
public class CourseController {
	
@Autowired
private CourseService courseservice;
	
	@PostMapping("/api/savecourse")
	
	public  ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course)
	{
	return new ResponseEntity<Course>(courseservice.saveCourse(course),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllCourse")
	public  List<Course> getAllCourse()
	{
		return courseservice.getAllCourse();
	}
	
	@GetMapping("/api/getCourseById/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Course>(courseservice.getCourseById(id),HttpStatus.OK);
	}
	
	@PutMapping("/api/updateCourseById/{id}")
	public ResponseEntity<Course> updateCourse(@Valid @PathVariable("id") int id,@RequestBody Course course)
	{
		return new ResponseEntity<Course>(courseservice.updateCourseById(course, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/api/deleteCourseById/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable("id")int id)
	{
		courseservice.deleteCById(id);
		return new ResponseEntity<String>("Course deleted successfully",HttpStatus.OK);
	}
	
	
	@GetMapping("/api/getCourseByName/{courseName}")
	public List<Course> getAllCourseByName(@PathVariable String courseName)
	{
		return courseservice.getAllCourseByName(courseName);
	}
	
	@GetMapping("/api/getCourseByFaculty/{courseFaculty}")
	public List<Course> getAllCourseByFaculty(@PathVariable String courseFaculty)
	{
		return courseservice.getAllCourseByFaculty(courseFaculty);
	}
	
}
