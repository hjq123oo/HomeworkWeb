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
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentHomeworkService;



@Controller
public class TeacherHomeworkController {
	@Resource
	ManageHomeworkService manageHomeworkService;
	
	@Resource
	ManageCourseService manageCourseService;
	
	@Resource
	ManageStudentHomeworkService manageStudentHomeworkService;
	
	@Resource
	HttpSession session;
	
	@RequestMapping(value="/teacher/course/{courseId}/homework/upload",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadHomework(@PathVariable Integer courseId,@RequestParam(value="file")  MultipartFile file) {
		
		
		File f=new File(FileRootUtil.getFileTemp()+courseId+"/"+file.getOriginalFilename());  
		
	
		try {
			if (!f.exists()) {
				if (!f.getParentFile().exists()) {
					// 如果目标文件所在的目录不存在，则创建父目录
					if (!f.getParentFile().mkdirs()) {
	
						return null;
					}
				}
					if (!f.createNewFile()) {
						return null;
					}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, String> result = new HashMap<String, String>();
		
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),f );
			
		} catch (IOException e) {
			result.put("success", "false");
			e.printStackTrace();
			return result;
		} 
		

		result.put("success", "true");
		result.put("fileName", file.getOriginalFilename());
		return result;
	}
	
	@RequestMapping(value = "/teacher/course/{courseId}/homework/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addHomework(@PathVariable("courseId") Integer courseId,
			@RequestParam("name") String name,@RequestParam("content") String content,
			@RequestParam("endTime") String strEndTime,@RequestParam(value="file")  MultipartFile file) {
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date endTime = null;
		try {
			endTime = sdf.parse(strEndTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Homework homework = new Homework();
		
		homework.setName(name);
		homework.setContent(content);
		homework.setEndTime(endTime);
		homework.setStartTime(new Date());
		
		manageCourseService.addHomework(courseId, homework);

		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
	
		return result;
	}
	
	
	@RequestMapping(value = "/teacher/course/{courseId}/homework/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getAllHomework(@PathVariable("courseId") Integer courseId) {
		
		List<Homework> homeworks = manageCourseService.getHomeworks(courseId);
		

		Map<String, String> result = new HashMap<String, String>();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		int size = homeworks.size();
		for (int i=0;i<size;i++){
			Homework homework = homeworks.get(i);
			result.put("id"+i, ""+homework.getHomeworkId());
			result.put("name"+i, homework.getName());
			result.put("startTime"+i, sdf.format(homework.getStartTime()));
			result.put("endTime"+i,  sdf.format(homework.getEndTime()));
			

		}

		return result;
	}
	
	
	
	@RequestMapping(value = "/teacher/course/{courseId}/homework/{homeworkId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getHomework(@PathVariable("courseId") Integer courseId,@PathVariable("homeworkId") Integer homeworkId) {

		Homework homework = manageHomeworkService.getHomework(homeworkId);

		Map<String, String> result = new HashMap<String, String>();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		
		result.put("id", ""+homework.getHomeworkId());
		result.put("name", homework.getName());
		result.put("content", homework.getContent());
		result.put("endTime",  sdf.format(homework.getEndTime()));
			

		

		return result;
	}
	
	/*
	@RequestMapping(value = "/teacher/homework/all/student_homework/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> saveCorrect() {
		

		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/teacher/homework/{homeworkId}/student_homework/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getStudentHomeworkByHoemwork(@RequestParam("homeworkId") Integer homeworkId) {
		

		Homework homework = manageHomeworkService.getHomework(homeworkId);
		
		List<StudentHomework> studentHomeworks = homework.getStudentHomeworks();
		
		Map<String, String> result = new HashMap<String, String>();

		for(StudentHomework studentHomework : studentHomeworks){
			Student student = studentHomework.getStudent();
			result.put("studentId", ""+student.getStudentId());
			result.put("homeworkId", homeworkId);
			result.put("studentNO",student.getStudentNO());
			result.put("name",student.getStudentNO());
			result.put("college",student.getCollege());
			result.put("className",student.getClassName());
			
		}

	

		return result;
	}
	
	
	@RequestMapping(value = "/teacher/homework/all/student_homework/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> saveCorrect() {
		

		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}
	
	*/
	
}
