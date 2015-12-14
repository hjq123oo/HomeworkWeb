package com.fiverings.homeworkweb.controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class CourseCenterControllerTest {
	private MockMvc mockMvc;
	

	@Resource
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void teacherCourseCenter() throws Exception {
		
		mockMvc.perform((get("/teacherCourseCenter").param("teacherId","1"))).andDo(print());
	}
	
	@Test
	public void createCourse() throws Exception {
		
		mockMvc.perform((post("/createCourse")
				.param("teacherId","1").param("college", "software").param("name", "JavaEE")
				.param("number", "A380").param("specialty", "112233").param("introduction","software_java")
				.param("time", "Wed-10-12").param("place", "YF313").param("lateInterval", "24")
				.param("latePercent", "10").param("endTime", "2015-12-15 8:00"))).andDo(print());
	}
	
	@Test
	public void joinCourse() throws Exception {
		
		mockMvc.perform((post("/joinCourse")
				.param("studentId","1").param("courseId", "1"))).andDo(print());
	}
	
}
