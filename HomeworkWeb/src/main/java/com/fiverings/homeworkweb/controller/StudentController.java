package com.fiverings.homeworkweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.service.ManageStudentService;


@Controller
public class StudentController {

	@Resource
	private ManageStudentService manageStudentService;
	
	@Resource
	private HttpSession session;
	
	
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addStudent(@RequestParam("name") String name, @RequestParam("pwd") String pwd,
			@RequestParam("school") String school, @RequestParam("college") String college,
			@RequestParam("className") String className, @RequestParam("studentNO") String studentNO,
			@RequestParam("realname") String realname, @RequestParam("email") String email,
			@RequestParam("phone") String phone) {

		Student student = new Student();
		student.setName(name);
		student.setPwd(pwd);
		student.setSchool(school);
		student.setCollege(college);
		student.setClassName(className);
		student.setStudentNO(studentNO);
		student.setRealname(realname);
		student.setEmail(email);
		student.setPhone(phone);

		manageStudentService.create(student);
		
		
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/student/info", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateStudentInfo(@PathVariable Integer id,
			@RequestParam("school") String school, @RequestParam("college") String college,
			@RequestParam("className") String className, @RequestParam("studentNO") String studentNO,
			@RequestParam("realname") String realname, @RequestParam("email") String email,
			@RequestParam("phone") String phone) {
		
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}
	
	
	@RequestMapping(value = "/student/pwd", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateStudentPwd(@PathVariable Integer id,@RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd){
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		return result;
	}
}
