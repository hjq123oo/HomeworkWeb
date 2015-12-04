package com.fiverings.homeworkweb.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.service.ManageStudentService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"}) 
public class ManageStudentServiceTest {
	@Autowired
	private ManageStudentService manageStudentService;
	
	
	@Test
	public void testCreate() throws Exception{
		Student student = new Student();
		student.setName("hjq");
		student.setPwd("hjq");
		student.setSchool("������ͨ��ѧ");
		student.setCollege("���ѧԺ");
		student.setClassName("1302");
		student.setStudentNO("13301036");
		student.setRealname("�Ƽ�ǿ");
		student.setEmail("13301036@bjtu.edu.cn");
		student.setPhone("18813097649");
		student.setFilePath("F:/jeeServer/student/hjq/");
/*
		mockMvc.perform(post("registerStudent.do").param("name","hjq")
				.param("pwd", "hjq").param("school", "������ͨ��ѧ")
				.param("college", "���ѧԺ").param("className", "1302")
				.param("studentNO", "13301036").param("realname", "�Ƽ�ǿ")
				.param("email", "13301036@bjtu.edu.cn").param("phone", "18813097649")
				.characterEncoding("UTF-8"));
		*/
		
		manageStudentService.create(student);
	}

}
