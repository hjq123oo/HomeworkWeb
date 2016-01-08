package com.fiverings.homeworkweb.servicetest;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.service.ManageCourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageCourseServiceTest {
	@Resource
	private ManageCourseService manageCourseService;
	
	@Test
	public void getCourseTest(){
		Course course = manageCourseService.getCourse(1);
		System.out.println("course:"+course.getCourseId()+" "+course.getName());
		System.out.println("teacher:"+course.getTeacher().getTeacherId()+" "+course.getTeacher().getName());
		System.out.println("\n");
	}
	
	
	@Test
	public void getHomeworksTest(){
		List<Homework> homeworks = manageCourseService.getHomeworks(1);
		
		int size = homeworks.size();
		System.out.println(size);
		
		for(int i=0;i<size;i++){
			System.out.println("homwork:"+homeworks.get(i).getHomeworkId()+" "+homeworks.get(i).getName());
		}
		System.out.println("\n");
	}
	
	
	@Test
	public void addHomeworkTest(){
		Homework homework = new Homework();
		homework.setContent("123");
		homework.setEndTime(new Date());
		homework.setName("132");
		
		manageCourseService.addHomework(1, homework);	
	}
}
