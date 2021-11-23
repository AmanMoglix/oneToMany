package com.example.dummy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dummy.entity.Courses;
import com.example.dummy.entity.Student;
import com.example.dummy.repository.CoursesRepository;
import com.example.dummy.repository.StudentRepository;
import com.example.dummy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CoursesRepository coursesRepository;

	@Override
	public Student save(Student student) {
		
		Student persistedStudent=studentRepository.save(student);
		
		List<Courses> courses=student.getCourses();
		
		for (Courses courses2 : courses) {
			courses2.setStudentId(persistedStudent.getId());
			this.coursesRepository.save(courses2);
		}
		  
		return persistedStudent;
	}

	@Override
	public List<Student> list() {
		return studentRepository.findAll();
	}

	public Student getById(Long id) {
		return studentRepository.getById(id);
	}

}
