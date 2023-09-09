package com.springrest.springrest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringrestApplicationTests {
	
	@Autowired
	CourseDao cd;

	@Test
	void contextLoads() {
	}

	//Create
	@Test
	@Order(1)
	public void createTest()
	{
		Course c=new Course();
		c.setId(1L);
		c.setTitle("Prof. AK Shankhwar");
		c.setDescription("Steady State Signal Systems");
		cd.save(c);
		assertNotNull(cd.findById(1L).get());
	}
	
	//Read ALL
	
	@Test
	@Order(2)
	public void ReadAllTest()
	{
		List<Course> list=cd.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	//Read Single
	@Test
	@Order(3)
	public void ReadSingleTest()
	{
		Course c1=cd.findById(1L).get();
		assertEquals(18.0, c1.getTitle().length());
	}
	
	//Update
	@Test
	@Order(4)
	public void UpdateTest()
	{
		Course c2=cd.findById(1L).get();
		c2.setTitle("R.N. Tripathi");
		cd.save(c2);
		assertNotEquals(18.0, c2.getTitle().length());
	}
	
	@Test
	@Order(5)
	public void delete()
	{
	     cd.deleteById(1L);
	     assertThat(cd.existsById(1L)).isFalse();
	}
}
