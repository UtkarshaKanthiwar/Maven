package com.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exception.CourseNotFoundException;
import com.model.Course;
import com.repository.CourseRepository;
import com.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courserepo;

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courserepo.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return courserepo.findById(id).orElseThrow(()-> new CourseNotFoundException("Course id not found"));
	}

	@Override
	public Course updateCourseById(Course course, int id) {
		// TODO Auto-generated method stub
		 Course existingcourse= courserepo.findById(id).orElseThrow(()-> new CourseNotFoundException("Course id not found"));
		 existingcourse.setCourseName(course.getCourseName());
		 existingcourse.setCourseFaculty(course.getCourseFaculty());
		 existingcourse.setCourseDuration(course.getCourseDuration());
		 existingcourse.setCourseFees(course.getCourseFees());
		 courserepo.save(existingcourse);
		 return existingcourse;
	}

	@Override
	public void deleteCById(int id) {
		// TODO Auto-generated method stub
		courserepo.findById(id).orElseThrow(()-> new CourseNotFoundException("Course id not found"));
		courserepo.deleteById(id);
	}

	@Override
	public List<Course> getAllCourseByName(String courseName) {
		// TODO Auto-generated method stub
		return courserepo.getAllCourseByName(courseName);
	}

	@Override
	public List<Course> getAllCourseByFaculty(String courseFaculty) {
		// TODO Auto-generated method stub
		return courserepo.getAllCourseByFaculty(courseFaculty);
	
	}
	
	}
