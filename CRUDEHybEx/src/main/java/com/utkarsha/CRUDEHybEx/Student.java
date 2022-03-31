package com.utkarsha.CRUDEHybEx;

import javax.persistence.*;

@Table(name="Student")
@Entity

public class Student {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="studentName")
private String studentName;

@Column(name="Phone", unique = true)
private long phone;

@Column(name="email", unique = true)
private String email;

@Column(name="fees")
private double fees;

@Column(name="course")
private String course;


public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public double getFees() {
	return fees;
}
public void setFees(double fees) {
	this.fees = fees;
}






}
