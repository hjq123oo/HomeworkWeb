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
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fiverings.homeworkweb.global.FileRootUtil;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentService;



@Controller
public class StudentHomeworkController {

	@Resource
	ManageStudentService manageStudentService;
	
	@Resource
	ManageCourseService manageCourseService;
	
	@Resource
	ManageHomeworkService manageHomeworkService;
	
	@Resource
	ManageStudentHomeworkService manageStudentHomeworkService;
	
	@Resource
	HttpSession session;
	
	
	@RequestMapping(value = "/student/homework/{homeworkId}/student_homework/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadHomework(@PathVariable Integer homeworkId,@RequestParam(value="file")  MultipartFile file) {

		Integer studentId = (Integer)session.getAttribute("id");
		Homework homework = manageHomeworkService.getHomework(homeworkId);
		

		//路径: /file/course/课程id/homework/作业id/
		String path = "/file/course/"+homework.getCourse().getCourseId()+"/homework/"+homeworkId+"/";
		
		Student student = manageStudentService.getStudent(studentId);
		String fileName = student.getStudentNO()+"-"+student.getRealname()+"-"+homework.getName();
		
		String filePath = path + fileName;
		
		File f=new File(FileRootUtil.getFileRoot()+filePath);  
		
		
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
