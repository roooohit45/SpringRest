package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService cService;

	@GetMapping("/home")
	public String home()
	{
		return "Courses Application";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.cService.getCourses();
	}
	
	@GetMapping("/courses/{cID}")
	public Course getCourse(@PathVariable String cID)
	{
		return this.cService.getCourse(Long.parseLong(cID));
	}
	@PostMapping(path="/courses", consumes = "application/json")
	public Course addCourse(@RequestBody Course course)
	{
		return this.cService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		
		return this.cService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{cID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String cID)
	{
		try {
			this.cService.deleteCourse(Long.parseLong(cID));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
