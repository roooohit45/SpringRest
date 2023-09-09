package com.springrest.springrest.service;

//import java.util.ArrayList;

import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImp implements CourseService {
	
	//List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImp()
	{
		//list=new ArrayList<>();
		//list.add(new Course(101,"Power System","Prof. Afroz Alam"));
		//list.add(new Course(102, "Power Station Practice","Prof. Yaduvir Singh"));
		//list.add(new Course(103,"Electric Machines","Prof. Jameel Ahmed"));
		//list.add(new Course(104,"Electrical Energy Conservation and Auditing","Prof. Archana Singh"));
		//list.add(new Course(105,"Advanced Control System","Prof. C.N. Singh"));
		//list.add(new Course(106,"Utilisation of Electrical Engineering","Prof. J.K. Dwivedi"));
	}

	@Override
	public List<Course> getCourses() {

		return courseDao.findAll();
		
		//return list;
	}

	@Override
	public Course getCourse(long cID) {
		
		/*Course c=null;
		
		for(Course course:list)
		{
			if(course.getId()==cID)
			{
				c=course;
				break;
			}
		}
	    try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return courseDao.findById(cID).get();
	}

	@Override
	public Course addCourse(Course course) {
		
		//list.add(course);
		courseDao.save(course);
		return course;
	}

    @Override
    public Course updateCourse(Course course)
    {
    	/*list.forEach(e ->
    	{
    		if(e.getId() == course.getId())
    		{
    			e.setTitle(course.getTitle());
    			e.setDescription(course.getDescription());
    		}
    	});*/
    	
    	courseDao.save(course);
    	return course;
    }

	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());
		Course entity=courseDao.findById(parseLong).get();
		courseDao.delete(entity);
	}

}
