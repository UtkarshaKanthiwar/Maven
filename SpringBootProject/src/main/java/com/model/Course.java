package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "co")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	@NotNull(message = "Please provid CourseName")
	private String courseName;
	@NotNull(message = "Please provid CourseDuration")
	private String courseDuration;
	@NotNull(message = "Please provid CourseFees")
	private Long courseFees;
	@NotNull(message = "Please provid CourseFaculty")
	private String courseFaculty;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("course")
	private List<Student> students;

	public Course(@NotNull(message = "Please provid CourseName") String courseName,
			@NotNull(message = "Please provid CourseDuration") String courseDuration,
			@NotNull(message = "Please provid CourseFees") Long courseFees,
			@NotNull(message = "Please provid CourseFaculty") String courseFaculty) {
		super();
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
		this.courseFaculty = courseFaculty;
	}
}
