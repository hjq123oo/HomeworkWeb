package com.fiverings.homeworkweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageStudentService;


@Controller
public class StudentCourseController {
	@Resource
	private ManageStudentService manageStudentService;
	
	@Resource
	private ManageCourseService manageCourseService;
	
	@Resource
	private HttpSession session;
	
	@RequestMapping(value = "/student/course/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getAllStudentCourse(){
		Integer studentId = (Integer)session.getAttribute("id");
		
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}
	
	@RequestMapping(value = "/student/course/{courseId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getStudentCourse(@PathVariable Integer courseId){
		Integer studentId = (Integer)session.getAttribute("id");
		
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}
	
	
	@RequestMapping(value = "/student/course/{courseId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> joinCourse(@PathVariable Integer courseId){
		Integer studentId = (Integer)session.getAttribute("id");
		
		
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}
	
}
