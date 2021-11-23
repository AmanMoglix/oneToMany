package com.example.dummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dummy.entity.Courses;
import com.example.dummy.model.CommonResponseObject;
import com.example.dummy.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/getbyId/{id}")
	public CommonResponseObject getById(@PathVariable("id") Long id) {
		return courseService.getById(id);
	}

	@GetMapping("/list")
	public List<CommonResponseObject> list() {
		return courseService.list();
	}
}
