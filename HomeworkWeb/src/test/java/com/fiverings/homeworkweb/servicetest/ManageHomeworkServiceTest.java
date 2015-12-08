package com.fiverings.homeworkweb.servicetest;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.jparepository.CourseJpaRepository;
import com.fiverings.homeworkweb.jparepository.HomeworkJpaRepository;
import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageHomeworkService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageHomeworkServiceTest {
	@Autowired
	private ManageHomeworkService manageHomeworkService;
	
	@Autowired
	private ManageCourseService manageCourseService;
	
	@Test
	public void testCreate() throws Exception{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date endTime = df.parse("2015-12-29 8:00");
		
		Homework homework = new Homework();
		homework.setName("��һ����ҵ");
		homework.setContent("��ҵ�����Ѹ��ϣ��밴ʱ�ύ��ҵ");
		homework.setEndTime(endTime);
		homework.setStartTime(new Date());
		
		Course course = manageCourseService.getCourse(1);
		homework.setCourse(course);
		
		homework.setFilePath("F:/jeeServer/course/"+course.getCourseId()+"/1.zip");
		
	
	}
	
	
	@Test
	public void testGetHomework() throws Exception{
	
		
		Homework homework = manageHomeworkService.getHomework(1);
		
		assertEquals("��һ����ҵ",homework.getName());
	}
}
