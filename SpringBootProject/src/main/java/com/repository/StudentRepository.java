package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("select s from Student s where s.firstName=?1")	
	List<Student> getStudentByfirstName(String firstName);
}