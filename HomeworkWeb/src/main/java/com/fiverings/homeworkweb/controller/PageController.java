package com.fiverings.homeworkweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/teacher/courseCenter")
	public String courseCenter() {
		return "teacher/courseCenter";
	}
	
	@RequestMapping("/student/personalInfo")
	public String studentInfo() {
		return "/student/personalInfo";
	}
	
	@RequestMapping("/teacher/personalInfo")
	public String teacherInfo() {
		return "/teacher/personalInfo";
	}
	
	@RequestMapping("/student/home")
	public String studentHome() {
		return "/student/home";
	}
}
