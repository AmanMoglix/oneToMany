package com.example.dummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dummy.entity.Student;
import com.example.dummy.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@GetMapping("list")
		public List<Student> list(){
		return studentService.list();
	}
	@GetMapping("/getbyId/{id}")
	public Student getById(@PathVariable("id")Long id) {
		return studentService.getById(id);
	}
	
}
