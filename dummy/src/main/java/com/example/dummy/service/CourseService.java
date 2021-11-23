package com.example.dummy.service;

import java.util.List;

import com.example.dummy.entity.Courses;
import com.example.dummy.model.CommonResponseObject;




public interface CourseService {

	public CommonResponseObject getById(Long id);

	public List<CommonResponseObject> list();
}
