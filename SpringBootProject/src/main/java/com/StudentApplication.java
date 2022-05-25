package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.model.Course;
import com.model.Student;
import com.repository.CourseRepository;
import com.repository.StudentRepository;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);

	}

	@Bean
	public CommandLineRunner mappingDemo(CourseRepository cRepository, StudentRepository sRepository) {
		return args -> {

			Course c = new Course();
			c.setId(100);
			c.setCourseName("java");
			c.setCourseDuration("3 months");
			c.setCourseFaculty("Mamta");
			c.setCourseFees(4000L);
			cRepository.save(c);
			sRepository.save(new Student(99, "a", "b", "ww@gmail.com", "3312345678", c));

			Course c2 = new Course();
			c.setId(200);
			c2.setCourseName("java");
			c2.setCourseDuration("3 months");
			c2.setCourseFaculty("Mamta");
			c2.setCourseFees(4000L);
			cRepository.save(c2);
			sRepository.save(new Student(88, "aa", "bb", "www@gmail.com", "3612345678", c2));

			System.out.println("---- saved ------");

		};
	}
}
