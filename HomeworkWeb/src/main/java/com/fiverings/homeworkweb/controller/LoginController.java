package com.fiverings.homeworkweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	/*
	@Resource
	private ManageUserService manageUserService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isLoggedin = false;

		if ("name".equalsIgnoreCase(name) && "pwd".equals(pwd)) {
			isLoggedin = true;
		}
		result.put("result", isLoggedin ? "��¼�ɹ�" : "��¼ʧ��");

		User user = new User();
		user.setId(1);
		user.setName(name);
		user.setPwd(pwd);
		
		result.put("person", "name");

		
		
		manageUserService.create(user);
		
		return result;
	}*/
}
