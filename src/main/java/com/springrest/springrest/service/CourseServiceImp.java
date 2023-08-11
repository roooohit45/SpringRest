package com.springrest.springrest.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImp implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImp()
	{
		list=new ArrayList<>();
		list.add(new Course(101,"Rohit Tyagi","Fresher with Bachelor Degree"));
		list.add(new Course(104,"Shubham Tyagi","4 year Job Experience"));
	}

	@Override
	public List<Course> getCourses() {

		return list;
	}

	@Override
	public Course getCourse(long cID) {
		
		Course c=null;
		
		for(Course course:list)
		{
			if(course.getId()==cID)
			{
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		return course;
	}

    @Override
    public Course updateCourse(Course course)
    {
    	list.forEach(e ->
    	{
    		if(e.getId() == course.getId())
    		{
    			e.setTitle(course.getTitle());
    			e.setDescription(course.getDescription());
    		}
    	});
    	return course;
    }

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());
	}

}
