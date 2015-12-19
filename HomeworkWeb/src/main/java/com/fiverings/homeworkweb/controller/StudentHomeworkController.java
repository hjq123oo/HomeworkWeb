package com.fiverings.homeworkweb.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentHomeworkService;



@Controller
public class StudentHomeworkController {

	@Resource
	ManageCourseService manageCourseService;
	
	@Resource
	ManageHomeworkService manageHomeworkService;
	
	@Resource
	ManageStudentHomeworkService manageStudentHomeworkService;
	
		
	@RequestMapping(value = "/student_homework/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadHomework(@RequestParam(value="file")  MultipartFile file) {

		File f=new File("E:/file");  
		
		
		Map<String, String> result = new HashMap<String, String>();
		
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),f );
		} catch (IOException e) {
			result.put("success", "false");
			e.printStackTrace();
			return result;
		} 
		
		
		

		result.put("success", "true");
		
		return result;
	}
}
