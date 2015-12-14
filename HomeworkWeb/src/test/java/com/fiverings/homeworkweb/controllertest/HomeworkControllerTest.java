package com.fiverings.homeworkweb.controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class HomeworkControllerTest {

	private MockMvc mockMvc;
	

	@Resource
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	

	@Test
	public void testCreateHomework() throws Exception {
		
		
		mockMvc.perform((post("/createHomework").param("courseId","1").param("name", "第一次作业").param("content", "好好做第一次作业")
				.param("endTime", "2016-01-01 8:00"))).andDo(print());
		
		
	}
	
	
	
	@Test
	public void testHomeworkDetail() throws Exception {
		
		
		mockMvc.perform((get("/homeworkDetail").param("homeworkId","1"))).andDo(print());
		
		
	}

	
	
	@Test
	public void testHomeworkList() throws Exception {
		
		
		mockMvc.perform((get("/homeworkList").param("courseId","1"))).andDo(print());
		
		
	}
	
	
	@Test
	public void testCorrect() throws Exception {
		
		
		mockMvc.perform((get("/correct").param("homeworkId","1"))).andDo(print());
		
		
	}
	
	
	@Test
	public void testSaveCorrect() throws Exception {
		
		
		mockMvc.perform((post("/saveCorrect").param("homeworkId","1").param("score1", "1").param("score2", "2").param("score3", "3"))).andDo(print());
		
		
	}
}
