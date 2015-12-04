package com.fiverings.homeworkweb.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.model.Teacher;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageTeacherServiceTest {
	@Autowired
	private ManageTeacherService manageTeacherService;
	
	@Test
	public void testCreate() throws Exception{
		Teacher teacher = new Teacher();
		teacher.setName("ggf");
		teacher.setPwd("123");
		teacher.setSchool("±±½»");
		teacher.setTeacherNO("aaa212");
		teacher.setEmail("123");
		teacher.setFilePath("123");
		teacher.setPhone("123");
		teacher.setRealName("¹ù¹Ø·É");
		
		manageTeacherService.create(teacher);
	}
}
