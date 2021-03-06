package com.fiverings.homeworkweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.Teacher;
import com.fiverings.homeworkweb.service.ManageStudentService;
import com.fiverings.homeworkweb.service.ManageTeacherService;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
public class TeacherController {
	@Resource
	private ManageTeacherService manageTeacherService;
	@Resource
	private ManageStudentService manageStudentService;
	
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

		Map<String, String> result = new HashMap<String, String>();
		
		//判断教师账号是否和其余教师账号重复
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = manageTeacherService.getAllTeachers();
		
		for(int i = 0; i < teacherList.size(); i++){
			if(name.equals(teacherList.get(i).getName())){
				result.put("success", "false");
				return result;
			}else{
				continue;
			}
		}	
		
		//判断教师账号是否和学生账号重复
		List<Student> studentList = new ArrayList<Student>();
		studentList = manageStudentService.getAllStudents();
		
		for(int i = 0; i < studentList.size(); i++){
			if(name.equals(studentList.get(i).getName())){
				result.put("success", "false");
				return result;
			}else{
				continue;
			}
		}
		
		manageTeacherService.create(teacher);
		result.put("success", "true");
		return result;
	}
	
	//获取教师信息
	@RequestMapping(value = "/teacher/info", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getTeacherInfo(){
		
		Map<String, String> result = new HashMap<String, String>();

		Teacher teacher = new Teacher();
		
		Integer id = (Integer)session.getAttribute("id");
		
		teacher = manageTeacherService.getTeacher(id);
		
		result.put("success", "true");
		result.put("name", teacher.getName());
		result.put("pwd", teacher.getPwd());
		result.put("school", teacher.getSchool());
		result.put("teacherNO", teacher.getTeacherNO());
		result.put("realname", teacher.getRealname());
		result.put("email", teacher.getEmail());
		result.put("phone", teacher.getPhone());
		
		return result;
	}
	
	@RequestMapping(value = "/teacher/info", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateTeacherInfo(
			@RequestParam("school") String school,
			@RequestParam("teacherNO") String teacherNo,
			@RequestParam("realName") String realname, 
			@RequestParam("email") String email,
			@RequestParam("phone") String phone){
		
		Integer id = (Integer)session.getAttribute("id");
		
		Teacher teacher = new Teacher();
		teacher.setTeacherId(id);
		teacher.setSchool(school);
		teacher.setTeacherNO(teacherNo);
		teacher.setRealname(realname);
		teacher.setEmail(email);
		teacher.setPhone(phone);
		
		Map<String, String> result = new HashMap<String, String>();

		manageTeacherService.updateInfo(teacher);
		result.put("success", "true");
		return result;
	}
	
	//修改教师密码
	@RequestMapping(value = "/teacher/modifyPwd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateTeacherPwd(
			@RequestParam("name") String name, 
			@RequestParam("oldPwd") String oldPwd, 
			@RequestParam("newPwd") String newPwd){
		
		Map<String, String> result = new HashMap<String, String>();
		
		Integer id = (Integer)session.getAttribute("id");
		
		Teacher teacher = new Teacher();
		teacher = manageTeacherService.getTeacher(id);
		
		if(oldPwd.equals(teacher.getPwd())){
			teacher.setPwd(newPwd);
			manageTeacherService.updatePwd(teacher);
			result.put("success", "true");
			return result;
		}
		
		result.put("success", "false");
		return result;
	}
	
	
}
