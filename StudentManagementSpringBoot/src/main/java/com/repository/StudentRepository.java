package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT u FROM Student u WHERE u.email=:email")
	List<Student> findUserByEmail(@Param("email") String email);

	@Query(value = "SELECT u FROM Student u WHERE u.mobile=:mobile")
	List<Student> findByMobile(@Param("mobile") Long mobile);
}
