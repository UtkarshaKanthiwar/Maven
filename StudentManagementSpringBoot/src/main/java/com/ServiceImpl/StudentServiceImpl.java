package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Student;
import com.repository.StudentRepository;
import com.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired

	StudentRepository studentrepo;

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student id not found"));
	}

	@Override
	public Student updateStudentById(Student student, int id) {
		// TODO Auto-generated method stub
		Student existingstudent = studentrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student id not found"));
		existingstudent.setFirstName(student.getFirstName());
		existingstudent.setLastName(student.getLastName());
		existingstudent.setEmail(student.getEmail());
		existingstudent.setMobile(student.getMobile());
		studentrepo.save(existingstudent);
		return existingstudent;

	}

	@Override
	public void deleteSById(int id) {
		// TODO Auto-generated method stub
		studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student id not found"));
		studentrepo.deleteById(id);
	}

	@Override
	public List<Student> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return studentrepo.findUserByEmail(email);
	}

	@Override
	public List<Student> findByMobile(Long mobile) {
		// TODO Auto-generated method stub
		return studentrepo.findByMobile(mobile);
	}

}
