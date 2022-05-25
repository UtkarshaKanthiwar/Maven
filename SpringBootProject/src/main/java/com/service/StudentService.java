package com.service;

import java.util.List;
import com.model.Student;

public interface StudentService {

	Student saveStudent(Student student);
	   
    List<Student> getAllStudent();
       
    Student getStudentById(int id);
      	     
    Student updateStudentById(Student student,int id);
           
     void deleteSById(int id);
           
       List<Student> getStudentByfirstName(String firstName);
}
