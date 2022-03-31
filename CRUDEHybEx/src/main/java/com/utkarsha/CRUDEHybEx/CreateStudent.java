package com.utkarsha.CRUDEHybEx;

import com.utkarsha.CRUDEHybEx.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.utkarsha.CRUDEHybEx.HibernateUtil;

public class CreateStudent {
	
	public static void main(String[] args) {
		
		Student student = new Student();
		
		student.setStudentName("Nikhil");
		student.setEmail("nikhi@123");
		student.setPhone(99856621);
	student.setCourse("Java");
	student.setFees(560.00);
	
	//create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//getting session object from session factory
		Session session = sessionFactory.openSession();
		
		//getting transaction object from session object
		session.beginTransaction();
		
		session.save(student);
		System.out.println("Record Inserted");
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}


}
