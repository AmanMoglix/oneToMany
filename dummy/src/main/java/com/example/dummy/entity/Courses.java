package com.example.dummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "course")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String courseName;

	@Column(name = "student_id")
	private Long studentId;
     
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id", nullable = true, updatable = false, insertable = false)
	private Student student;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Student getStudent() {
		return new Student();
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
