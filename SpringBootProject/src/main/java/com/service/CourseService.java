package com.service;

import java.util.List;
import com.model.Course;

public interface CourseService {

	Course saveCourse(Course course);
	   
    List<Course> getAllCourse();
       
    Course getCourseById(int id);
      	     
    Course updateCourseById(Course course,int id);
           
     void deleteCById(int id);
           
       List<Course> getAllCourseByName(String courseName);
	
       List<Course> getAllCourseByFaculty(String courseFaculty);
}
