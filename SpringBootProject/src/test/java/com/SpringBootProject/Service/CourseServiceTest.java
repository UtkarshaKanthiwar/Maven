package com.SpringBootProject.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Course;
import com.repository.CourseRepository;
import com.service.CourseService;

@SpringBootTest

public class CourseServiceTest {


	@Autowired
	private CourseService courseService;
	
	@MockBean
	private CourseRepository courseRepository;

	@Test
	public void testSaveCourse()
	{
		Course course=new Course();
		course.setId(11);
		course.setCourseName("Spring boot");
		course.setCourseFaculty("Ankita");
		course.setCourseDuration("5");
		course.setCourseFees((long) 2000);
		Mockito.when(courseRepository.save(course)).thenReturn(course);
		assertThat(courseService.saveCourse(course)).isEqualTo(course);
	}
	
	@Test
	public void testGetAllCourses()
	{
		Course c1=new Course();
		c1.setCourseDuration("6 month");
		c1.setCourseFaculty("Mamta Boga");
		c1.setCourseFees((long) 20000);
		c1.setCourseName("Java");
		
		Course c2=new Course();
		c2.setCourseDuration("7 month");
		c2.setCourseFaculty("Priya");
		c2.setCourseFees((long) 6500);
		c2.setCourseName("Dot");
		
		List<Course> list=new ArrayList<>();
		list.add(c1);
		list.add(c2);
		
		Mockito.when(courseRepository.findAll()).thenReturn(list);
		
		assertThat(courseService.getAllCourse()).isEqualTo(list);
	}
	
	@Test
	public void testDeleteCourse()
	{
		
		Course c3=new Course();
		c3.setCourseDuration("7 month");
		c3.setCourseFaculty("Priya");
		c3.setCourseFees((long) 6500);
		c3.setCourseName("Dot");
		
		Optional<Course> bk=Optional.of(c3);
		
		//Mockito.when(bookRepository.findById(101l)).thenReturn(bk);
		Mockito.when(courseRepository.existsById(bk.get().getId())).thenReturn(false);//existById(101)? false
		assertThat(courseRepository.existsById(bk.get().getId()));
	}
	
	@Test
	public void testUpdateCourse()
	{
		Course c4=new Course();
		c4.setId(3);
		c4.setCourseDuration("6 month");
		c4.setCourseFaculty("Mamta Boga");
		c4.setCourseFees((long) 20000);
		c4.setCourseName("Java");
		
		
		Optional<Course> bk1=Optional.of(c4);
		Course course=bk1.get();
		Mockito.when(courseRepository.findById(3)).thenReturn(bk1);
		course.setCourseName("Sql");
		Mockito.when(courseRepository.save(course)).thenReturn(course);
		assertThat(courseService.updateCourseById(course, 3)).isEqualTo(course);
	}
	
}