package com.SpringBootProject.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.controller.CourseController;
import com.model.Course;
import com.service.CourseService;



@WebMvcTest(CourseController.class)
public class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private Course course=new Course();
	
	@MockBean
	private CourseService courseService;
	
	@Test
	public void testSaveCourse() throws Exception
	{
		course=new Course();
		course.setId(11);
		course.setCourseName("Spring boot");
		course.setCourseFaculty("Ankita");
		course.setCourseDuration("5");
		course.setCourseFees((long) 2000);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/savecourse").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "  \"id\": 11,\r\n" + "  \"courseName\": \"Spring boot\","
						+ "\r\n" + "  \"courseFaculty\": \"Ankita\",\r\n"
						+ "  \"courseDuration\": \"5\",\r\n" + "  \"courseFees\": \"2000\"\r\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isCreated());	
	
	}
}
