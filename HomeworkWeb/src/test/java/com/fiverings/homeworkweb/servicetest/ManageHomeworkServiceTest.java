package com.fiverings.homeworkweb.servicetest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.service.ManageHomeworkService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageHomeworkServiceTest {
	@Resource
	private ManageHomeworkService manageHomeworkService;
	
	@Test
	public void getHomeworkTest(){
		Homework homework = manageHomeworkService.getHomework(1);
		System.out.println("homework:" + homework.getHomeworkId()+" "+homework.getName());
	}
	
	
	@Test
	public void getStudentHomeworksTest(){
		List<StudentHomework> studentHomeworks = manageHomeworkService.getStudentHomeworks(1);
		
		int size = studentHomeworks.size();
		System.out.println(size);
		
		for(int i=0;i<size;i++){
			System.out.println("Student:"+studentHomeworks.get(i).getStudent().getStudentId()+" "+studentHomeworks.get(i).getStudent().getRealname()+" Homework:"+studentHomeworks.get(i).getHomework().getHomeworkId()+" "+studentHomeworks.get(i).getHomework().getName());
		}
		
		System.out.println("\n");
	
	}
	
	
}
