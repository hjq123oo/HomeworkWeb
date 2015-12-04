package com.fiverings.homeworkweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.service.ManageStudentService;

@Controller
public class RegisterController {

	@Resource
	private ManageStudentService manageStudentService;

	@RequestMapping(value = "/registerStudent.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerStudent(@RequestParam("name") String name, @RequestParam("pwd") String pwd,
			@RequestParam("school") String school, @RequestParam("college") String college,
			@RequestParam("className") String className, @RequestParam("studentNo") String studentNO,
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
		student.setFilePath("F:/server/student/" + name + "/");

		manageStudentService.create(student);
		Map<String, String> result = new HashMap<String, String>();

		return result;
	}
}
