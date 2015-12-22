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
	public String teacherCourseCenter() {
		return "teacher/courseCenter";
	}
	

	
	@RequestMapping("/student/course")
	public String studentCourse() {
		return "student/course";
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
	
	@RequestMapping("/teacher/course")
	public String teacherCourse() {
		return "/teacher/course";
	}

	@RequestMapping("/teacher/courseCreate")
	public String courseCreate(){
		return "/teacher/courseCreate";
	}
	
	@RequestMapping("/teacher/modifyPwd")
	public String modifyTeacherPwd(){
		return "/teacher/modifyPwd";
	}
	
	@RequestMapping("/student/modifyPwd")
	public String modifyStudentPwd(){
		return "/student/modifyPwd";
	}
	
	@RequestMapping("/student/courseCenter")
	public String studentCourseCenter() {
		return "student/courseCenter";
	}
	
	@RequestMapping("/student/searchPage")
	public String searchPage() {
		return "student/searchPage";
	}
	
	@RequestMapping("/teacher/homeworkCreate")
	public String homeworkCreate() {
		return "teacher/homeworkCreate";
	}
	
	
	@RequestMapping("/teacher/homework")
	public String teacherHomework() {
		return "teacher/homework";
	}
	
	@RequestMapping("/student/homework")
	public String studentHomework() {
		return "student/homework";
	}
	
	@RequestMapping("/teacher/correct")
	public String teacherCorrect() {
		return "teacher/correct";
	}
	
	@RequestMapping("/student/student_homework/rest")
	public String getHomeworks() {
		return "student/home";
	}
}
