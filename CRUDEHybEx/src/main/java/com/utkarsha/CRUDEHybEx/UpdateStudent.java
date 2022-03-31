package com.utkarsha.CRUDEHybEx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudent {
	
	public static void main(String[] args) {
	//create session factory object
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			//getting session object from session factory
			Session session = sessionFactory.openSession();
			
			//getting transaction object from session object
			session.beginTransaction();
			
			Student student = session.get(Student.class, 3);
			student.setStudentName("Ankit");
			System.out.println("Record updated");
			session.getTransaction().commit();
			sessionFactory.close();
			
}
}