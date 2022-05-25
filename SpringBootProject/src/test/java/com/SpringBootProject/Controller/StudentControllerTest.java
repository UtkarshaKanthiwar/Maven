package com.SpringBootProject.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.controller.StudentController;
import com.model.Student;
import com.service.StudentService;

@WebMvcTest(StudentController.class)

public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private Student student=new Student();
	
	@MockBean
	private StudentService studentService;
	
	@BeforeEach
	void setUp()
	{
		student=new Student();
		student.setSid(4);
		student.setFirstName("Mahi");
		student.setLastName("Kanthiwar");
		student.setEmail("mahi@gmail.com");
		student.setPhoneNo("9544253655");
	
	}
	
	@Test
	public void testSaveStudent() throws Exception
	{
		student=new Student();
		student.setSid(4);
		student.setFirstName("Mahi");
		student.setLastName("Kanthiwar");
		student.setEmail("mahi@gmail.com");
		student.setPhoneNo("9544253655");
		
		//Mockito.when(bookService.savestudent(student)).thenReturn(student);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/savestudent").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "  \"sid\": 4,\r\n" + "  \"firstName\": \"Mahi\","
						+ "\r\n" + "  \"lastName\": \"Kanthiwar\",\r\n"
						+ "  \"email\": \"mahi@gmail.com\",\r\n" + "  \"phoneNo\": \"9544253655\"\r\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isCreated());	
	}	
	
}