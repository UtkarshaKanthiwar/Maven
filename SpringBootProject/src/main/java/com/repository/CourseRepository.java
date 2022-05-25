package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	@Query("select d from Course d where d.courseName=?1")	
	List<Course> getAllCourseByName(String courseName);

	@Query("select d from Course d where d.courseFaculty=?1")	
	List<Course> getAllCourseByFaculty(String courseFaculty);
	
}
