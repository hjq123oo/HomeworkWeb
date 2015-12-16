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

import com.fiverings.homeworkweb.model.Teacher;
import com.fiverings.homeworkweb.service.ManageTeacherService;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
public class TeacherController {
	@Resource
	private ManageTeacherService manageTeacherService;
	
	@Resource
	private HttpSession session;
	
	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addTeacher(@RequestParam("name") String name, @RequestParam("pwd") String pwd,
			@RequestParam("school") String school,@RequestParam("teacherNO") String teacherNo,
			@RequestParam("realname") String realname, @RequestParam("email") String email,
			@RequestParam("phone") String phone){
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setPwd(pwd);
		teacher.setSchool(school);
		teacher.setTeacherNO(teacherNo);
		teacher.setRealname(realname);
		teacher.setEmail(email);
		teacher.setPhone(phone);

		manageTeacherService.create(teacher);
		
	
		Map<String, String> result = new HashMap<String, String>();
		if(phone == phone){
			result.put("success", "true");
		}else{
			result.put("success", "false");
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/teacher/info", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateTeacherInfo(@PathVariable Integer id,
			@RequestParam("school") String school,@RequestParam("teacherNO") String teacherNo,
			@RequestParam("realname") String realname, @RequestParam("email") String email,
			@RequestParam("phone") String phone){
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		return result;
	}
	
	
	@RequestMapping(value = "/teacher/pwd", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateTeacherPwd(@PathVariable Integer id,@RequestParam("oldPwd") String oldPwd, @RequestParam("newPwd") String newPwd){
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		return result;
	}
	
}
