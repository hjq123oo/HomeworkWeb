package com.fiverings.homeworkweb.servicetest;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations = { "classpath:spring-servlet.xml","classpath:applicationContext.xml"
,"classpath:applicationContext-persistence.xml"})
public class RegisterControllerTest {
	
	private MockMvc mockMvc;
	

	@Resource
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testRegisterTeacher() throws Exception {
		
		mockMvc.perform((post("/registerTeacher").param("name","ggf").param("pwd", "123").param("school", "北交")
				.param("teacherNO", "abc123").param("email", "123@qq.com")
				.param("phone", "18813091234").param("realname", "郭关飞"))).andDo(print());
		
		
	}
	
	@Test
	public void testRegisterStudent() throws Exception {
		
		
		mockMvc.perform((post("/registerStudent").param("name","hjq").param("pwd", "123").param("school", "北交")
				.param("college", "软件学院").param("className", "1302").param("studentNO", "13301036")
				.param("realname", "黄坚强").param("email", "13301036@bjtu.edu.cn"))
				.param("phone", "18813097649")).andDo(print());
		
		
	}
}
