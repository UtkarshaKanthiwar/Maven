package com.SpringBootProject.Service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Student;
import com.repository.StudentRepository;
import com.service.StudentService;

@SpringBootTest

public class StudentServiceTest {

	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void testSaveStudent()
	{
		Student student=new Student();
		student.setFirstName("Priya");
		student.setLastName("Rai");
		student.setEmail("priya@gmail.com");
		student.setPhoneNo("9874532156");
		
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertThat(studentService.saveStudent(student)).isEqualTo(student);
	}
	
	@Test
	public void testGetAllStudents()
	{
		Student s1=new Student();
		s1.setFirstName("Ankita");
		s1.setLastName("Roy");
		s1.setEmail("Anki@gmail.com");
		s1.setPhoneNo("123456");
		
		Student s2=new Student();
		s2.setFirstName("Nikita");
		s2.setLastName("Rai");
		s2.setEmail("niki@gmail.com");
		s2.setPhoneNo("123786");
		
		List<Student> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		
		Mockito.when(studentRepository.findAll()).thenReturn(list);
		
		assertThat(studentService.getAllStudent()).isEqualTo(list);
	}
	
	@Test
	public void testDeleteStudent()
	{
		Student s3=new Student();
		s3.setSid(7);
		s3.setFirstName("Diya");
		s3.setLastName("Dev");
		s3.setEmail("diya@gmail.com");
		s3.setPhoneNo("9656454673");
		
		Optional<Student> bk=Optional.of(s3);
		
		//Mockito.when(bookRepository.findById(101l)).thenReturn(bk);
		Mockito.when(studentRepository.existsById(bk.get().getSid())).thenReturn(false);//existById(101)? false
		assertThat(studentRepository.existsById(bk.get().getSid()));
	}
	
	@Test
	public void testUpdateStudent()
	{
		Student s4=new Student();
		s4.setSid(8);
		s4.setFirstName("Riya");
		s4.setLastName("Roy");
		s4.setEmail("riya@gmail.com");
		s4.setPhoneNo("345678921");
		
		Optional<Student> bk1=Optional.of(s4);
		Student student=bk1.get();
		
		Mockito.when(studentRepository.findById(8)).thenReturn(bk1);
		student.setPhoneNo("9566435722");
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertThat(studentService.updateStudentById(student, 8)).isEqualTo(student);
	}
	
}