package com.utkarsha.CRUDEHybEx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudent1 {
public static void main(String[] args) {
	
	//create session factory object
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	//getting session object from session factory
	Session session = sessionFactory.openSession();
	
	//getting transaction object from session object
	session.beginTransaction();
	
	Student student = session.load(Student.class, 3);
	session.delete(student);
	System.out.println("Record deleted");
	session.getTransaction().commit();
	sessionFactory.close();
}
}
