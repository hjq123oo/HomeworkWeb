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
import com.fiverings.homeworkweb.model.Teacher;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageTeacherServiceTest {
	
	@Resource
	private ManageTeacherService manageTeacherService;
	
	@Test
	public void createTest(){
		Teacher teacher = new Teacher();
		teacher.setEmail("123@123.com");
		teacher.setName("hjq");
		teacher.setPhone("133333333");
		teacher.setPwd("123");
		teacher.setRealname("黄坚强");
		teacher.setSchool("北大");
		teacher.setTeacherNO("1234");
		
		manageTeacherService.create(teacher);
	}
	
	@Test
	public void updateInfoTest(){
		Teacher teacher = new Teacher();
		teacher.setTeacherId(2);
		teacher.setEmail("123@123.com");
		teacher.setName("hjq");
		teacher.setPhone("133333333");
		teacher.setRealname("黄坚强");
		teacher.setSchool("北大");
		teacher.setTeacherNO("1234");
		
		manageTeacherService.updateInfo(teacher);
	}
	
	@Test
	public void updatePwdTest(){
		Teacher teacher = new Teacher();
		teacher.setTeacherId(2);
	
		teacher.setPwd("1234");
		
		manageTeacherService.updatePwd(teacher);
	}
	
	@Test
	public void addCourseTest(){
		Course course = new Course();
		course.setCollege("大学");
		course.setEndTime(new Date());
		course.setIntroduction("介绍");
		course.setLateInterval(24);
		course.setLatePercent(20);
		course.setName("课程");
		course.setNumber("课程号");
		course.setSpecialty("专业");
		course.setTime("周三第三节");
		
		manageTeacherService.addCourse(1, course);
	}
	
	@Test
	public void getCoursesTest(){
		List<Course> courses = manageTeacherService.getCourses(1);
		
		int size = courses.size();
		
		System.out.println(size);
		
		for(int i=0;i<size;i++){
			System.out.println(courses.get(i).getCourseId()+" "+courses.get(i).getName());
		}
		System.out.println("\n");
	}
}
