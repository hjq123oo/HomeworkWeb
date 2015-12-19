package com.fiverings.homeworkweb.servicetest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.service.ManageStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class ManageStudentServiceTest {

	@Resource
	private ManageStudentService manageStudentService;
	
	@Test
	public void createTest(){
		Student student = new Student();
		student.setClassName("班级");
		student.setCollege("学院");
		student.setEmail("12@12.com");
		student.setName("hjq");
		student.setPhone("123456");
		student.setRealname("黄坚强");
		student.setPwd("123");
		student.setSchool("学校");
		student.setStudentNO("133010");
		manageStudentService.create(student);
	}
	
	
	@Test
	public void addCourseTest(){
		manageStudentService.addCourse(2, 1);
		
	}
	
	@Test
	public void getCoursesTest(){
		List<Course> courses = manageStudentService.getCourses(1);
		
		int size = courses.size();
		
		System.out.println(size);
		
		for(int i=0;i<size;i++){
			System.out.println(courses.get(i).getCourseId()+" "+courses.get(i).getName());
		}
		System.out.println("\n");
		
	}
	
}
