package com.example.dummy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dummy.entity.Courses;
import com.example.dummy.entity.Student;
import com.example.dummy.model.CommonResponseObject;
import com.example.dummy.repository.CoursesRepository;
import com.example.dummy.repository.StudentRepository;
import com.example.dummy.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CoursesRepository coursesRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public CommonResponseObject getById(Long id) {
		CommonResponseObject commonResponseObject =new CommonResponseObject();

		Courses courses = coursesRepository.getById(id);
		
		commonResponseObject.setCourseId(courses.getId());
		commonResponseObject.setCourseName(courses.getCourseName());
		if(courses.getStudentId()!=null) {
		Student student = studentRepository.getById(courses.getStudentId());
		commonResponseObject.setStudentId(student.getId());
		commonResponseObject.setStudentName(student.getUserName());
		}
		return commonResponseObject;
	}

	@Override
	public List<CommonResponseObject> list() {
		List<CommonResponseObject> commonResponseObjects= new ArrayList<CommonResponseObject>();
		List<Courses> cuList = coursesRepository.findAll();
		
		for (Courses courses : cuList) {
			
			CommonResponseObject commonResponseObject =new CommonResponseObject();
			commonResponseObject.setCourseId(courses.getId());
			commonResponseObject.setCourseName(courses.getCourseName());
			if(courses.getStudentId()!=null) {
			Student student = studentRepository.getById(courses.getStudentId());
			commonResponseObject.setStudentId(student.getId());
			commonResponseObject.setStudentName(student.getUserName());
			}
			commonResponseObjects.add(commonResponseObject);
		}
		return commonResponseObjects;
	}

}
