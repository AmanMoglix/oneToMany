package com.example.dummy.service;

import java.util.List;

import com.example.dummy.entity.Student;

public interface StudentService {
	
	public Student save(Student student);
	public List<Student> list();
	public Student getById(Long id);
}
