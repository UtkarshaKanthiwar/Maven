package com.utkarsha.CRUDEHybEx;

import java.util.Iterator;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.utkarsha.CRUDEHybEx.Student;
import com.utkarsha.CRUDEHybEx.HibernateUtil;

public class ReadStudent {
public static void main(String[] args) {
	
	//create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//getting session object from session factory
		Session session = sessionFactory.openSession();
		
		//getting transaction object from session object
		session.beginTransaction();
		
		Query query = session.createQuery("from Student");
		List students = query.list();
		for(Iterator iterator = students.iterator(); iterator.hasNext();) {
			Student student=(Student) iterator.next();
			System.out.print("Id is :"  + student.getId());
			System.out.print("Name is :"  + student.getStudentName());
			System.out.print("Course is :"  + student.getCourse());
			System.out.print("Email is :"  + student.getEmail());
			System.out.print("Phone is :"  + student.getPhone());
		}
		session.getTransaction().commit();
		sessionFactory.close();
}
}
