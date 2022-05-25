package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "so")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	@NotNull(message = "Please provid FirstName")
	private String firstName;
	@NotNull(message = "Please provid LastName")
	private String lastName;
	@Email(message = "Please provid Email")
	private String email;
	@NotNull(message = "Please provid PhoneNo")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	@ManyToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	@JsonIgnoreProperties("students")
	private Course course;

	public Student(@NotNull(message = "Please provid FirstName") String firstName,
			@NotNull(message = "Please provid LastName") String lastName,
			@Email(message = "Please provid Email") String email,
			@NotNull(message = "Please provid PhoneNo") @Pattern(regexp = "(^$|[0-9]{10})") String phoneNo,
			Course course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.course = course;
	}

}