package com.springrest.springrest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.entity.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course getCourse(long cID);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);
}
