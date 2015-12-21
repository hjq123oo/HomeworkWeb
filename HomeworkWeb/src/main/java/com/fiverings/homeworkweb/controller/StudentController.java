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

import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.Teacher;
import com.fiverings.homeworkweb.service.ManageStudentService;
import com.fiverings.homeworkweb.service.ManageTeacherService;


@Controller
public class StudentController {

	@Resource
	private ManageStudentService manageStudentService;
	
	@Resource
	private ManageTeacherService manageTeacherService;
	
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

		
		
		Map<String, String> result = new HashMap<String, String>();
		
		//判断学生账号是否和其余学生账号重复
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
		
		//判断学生账号是否和教师账号重复
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
		
		manageStudentService.create(student);
		result.put("success", "true");
		
		return result;
	}
	
	//获取学生信息
	@RequestMapping(value = "/student/info", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getStudentInfo() {
		
		Student student = new Student();
		
		Integer id = (Integer)session.getAttribute("id");
		
		student = manageStudentService.getStudent(id);
			
		Map<String, String> result = new HashMap<String, String>();
		result.put("success", "true");
		result.put("name", student.getName());
		result.put("pwd", student.getPwd());
		result.put("school", student.getSchool());
		result.put("college", student.getCollege());
		result.put("className", student.getClassName());
		result.put("studentNo", student.getStudentNO());
		result.put("realName", student.getRealname());
		result.put("email", student.getEmail());
		result.put("phone", student.getPhone());
		
		return result;
	}
	
	//修改学生信息
	@RequestMapping(value = "/student/info", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateStudentInfo(
			@RequestParam("school") String school, 
			@RequestParam("college") String college,
			@RequestParam("className") String className, 
			@RequestParam("studentNO") String studentNO,
			@RequestParam("realName") String realname, 
			@RequestParam("email") String email,
			@RequestParam("phone") String phone) {
		
		Integer id = (Integer)session.getAttribute("id");
		
		Student student = new Student();
		student.setStudentId(id);
		student.setSchool(school);
		student.setCollege(college);
		student.setClassName(className);
		student.setStudentNO(studentNO);
		student.setRealname(realname);
		student.setEmail(email);
		student.setPhone(phone);
		
		Map<String, String> result = new HashMap<String, String>();
		
		manageStudentService.updateInfo(student);
		result.put("success", "true");
		
		return result;
	}
	
	
	//修改学生密码
	@RequestMapping(value = "/student/modifyPwd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateStudentPwd(
			@RequestParam("name") String name, 
			@RequestParam("oldPwd") String oldPwd, 
			@RequestParam("newPwd") String newPwd){
		
		Map<String, String> result = new HashMap<String, String>();
		
		Integer id = (Integer)session.getAttribute("id");
		
		Student student = new Student();
		student = manageStudentService.getStudent(id);
		
		if(oldPwd.equals(student.getPwd())){
			student.setPwd(newPwd);
			
			manageStudentService.updatePwd(student);
			result.put("success", "true");
			return result;
		}
		
		result.put("success", "false");
		return result;
	}
}
