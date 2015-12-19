package com.fiverings.homeworkweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.Teacher;
import com.fiverings.homeworkweb.service.ManageStudentService;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@Controller
public class LoginController {

	@Resource
	private ManageStudentService manageStudentService;
	
	@Resource
	private ManageTeacherService manageTeacherService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
		Map<String, String> result = new HashMap<String, String>();
		
		//学生列表
		List<Student> studentList = new ArrayList<Student>();
		studentList = manageStudentService.getAllStudents();
		
		//教师列表
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = manageTeacherService.getAllTeachers();
		
		//检查学生账号
		for(int i = 0; i < studentList.size(); i++){
			if(name.equals(studentList.get(i).getName())){
				if(pwd.equals(studentList.get(i).getPwd())){
					result.put("result", "true");
					result.put("name", name);
					result.put("pwd", pwd);
					return result;
				}
				
			}else{
				continue;
			}
		}
		
		//检查教师账号
		for(int i = 0; i < teacherList.size(); i++){
			if(name.equals(teacherList.get(i).getName())){
				if(pwd.equals(teacherList.get(i).getPwd())){
					result.put("result", "true");
					result.put("name", name);
					result.put("pwd", pwd);
					return result;
				}
			}else{
				continue;
			}
		}
		
		result.put("result", "false");
		result.put("name", "no");
		result.put("pwd", "no");
		
		return result;
	}
}
