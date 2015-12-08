package com.fiverings.homeworkweb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fiverings.homeworkweb.service.ManageStudentService;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@Controller
public class LoginController {

	@Resource
	private ManageStudentService manageStudentService;
	
	@Resource
	private ManageTeacherService manageTeacherService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	/*
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isLoggedin = false;

		if ("name".equalsIgnoreCase(name) && "pwd".equals(pwd)) {
			isLoggedin = true;
		}
		result.put("result", isLoggedin ? "µÇÂ¼³É¹¦" : "µÇÂ¼Ê§°Ü");

		User user = new User();
		user.setId(1);
		user.setName(name);
		user.setPwd(pwd);
		
		result.put("person", "name");

		
		
		manageUserService.create(user);
		
		return result;
	}*/
}
