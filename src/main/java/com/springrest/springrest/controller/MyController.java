package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	//GET ALL
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses()
	{
		List<Course> list=cService.getCourses();
		
		if(list.size()<=0)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	//GET A SINGLE
	
	@GetMapping("/courses/{cID}")
	public ResponseEntity<Course> getCourse(@PathVariable long cID)
	{
		try {
		Course course=cService.getCourse(cID);
		return ResponseEntity.of(Optional.of(course));
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//CREATE
	
	@PostMapping(path="/courses", consumes = "application/json")
	public ResponseEntity<Course> addCourse(@RequestBody Course course)
	{
		try {
			Course c1=this.cService.addCourse(course);
			System.out.print(c1);
			return ResponseEntity.of(Optional.of(c1));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//UPDATE
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course)
	{
		try {
			this.cService.updateCourse(course);
			return ResponseEntity.ok().body(course);
		} 
		catch (Exception e) {
	      e.printStackTrace();
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//DELETE
	
	@DeleteMapping("/courses/{cID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long cID)
	{
		try {
			this.cService.deleteCourse(cID);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
