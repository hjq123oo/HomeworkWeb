package com.fiverings.homeworkweb.servicetest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.service.ManageStudentHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageStudentHomeworkServiceTest {
	@Resource
	private ManageStudentHomeworkService manageStudentHomeworkService;
	
	@Test
	public void getStudentHomework(){
		Integer studentId = 1;
		Integer homeworkId = 2;
		StudentHomework studentHomework = manageStudentHomeworkService.getStudentHomework(studentId, homeworkId);
		System.out.print(studentHomework.getId());
	}
}
