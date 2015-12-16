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
}
