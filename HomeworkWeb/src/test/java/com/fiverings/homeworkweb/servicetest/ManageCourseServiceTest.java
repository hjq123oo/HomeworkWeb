package com.fiverings.homeworkweb.servicetest;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageCourseServiceTest {
	@Autowired
	private ManageCourseService manageCourseService;
	
	@Autowired
	private ManageTeacherService manageTeacherService;
	
	
	@Test
	public void testCreate() throws Exception{
		Course course = new Course();
		course.setCollege("软件");
		course.setEndTime(new Date());
		course.setFilePath("123");
		course.setIntroduction("课程");
		course.setName("javaee");
		course.setNumber("ac12");
		course.setPlace("逸夫");
		course.setSpecialty("软件");
		course.setStartTime(new Date());
		course.setTime("星期五第二节");
		course.setTeacher(manageTeacherService.getTeacher(1));
		
		manageCourseService.create(course);
		
		
	}
}
