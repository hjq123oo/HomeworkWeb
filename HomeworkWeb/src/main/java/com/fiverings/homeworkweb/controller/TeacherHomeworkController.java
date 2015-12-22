package com.fiverings.homeworkweb.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentHomeworkService;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@Controller
public class TeacherHomeworkController {
	@Resource
	ManageHomeworkService manageHomeworkService;

	@Resource
	ManageCourseService manageCourseService;

	@Resource
	ManageStudentHomeworkService manageStudentHomeworkService;
	
	@Resource
	ManageTeacherService ManageteacherService;

	@Resource
	HttpSession session;

	@RequestMapping(value = "/teacher/course/{courseId}/homework/upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadHomework(@PathVariable Integer courseId,
			@RequestParam(value = "file") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("content") String content, @RequestParam("endTime") String strEndTime) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

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
		Date date = new Date();
		homework.setStartTime(date);
	
		
		
		manageCourseService.addHomework(courseId, homework,file);
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("success", "true");
		
		return result;
	}

	@RequestMapping(value = "/teacher/course/{courseId}/homework/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addHomework(@PathVariable("courseId") Integer courseId,
			@RequestParam("name") String name, @RequestParam("content") String content,
			@RequestParam("endTime") String strEndTime) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

		int size = homeworks.size();
		for (int i = 0; i < size; i++) {
			Homework homework = homeworks.get(i);
			result.put("id" + i, "" + homework.getHomeworkId());
			result.put("name" + i, homework.getName());
			result.put("startTime" + i, sdf.format(homework.getStartTime()));
			result.put("endTime" + i, sdf.format(homework.getEndTime()));

		}

		return result;
	}

	@RequestMapping(value = "/teacher/homework/{homeworkId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getHomework(@PathVariable("homeworkId") Integer homeworkId) {

		Homework homework = manageHomeworkService.getHomework(homeworkId);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("homework", homework);

		return result;
	}
	
	
	@RequestMapping(value = "/teacher/homework/{homeworkId}/student_homework/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllStudentHomework(@PathVariable("homeworkId") Integer homeworkId) {

		
		List<StudentHomework> studentHomeworks = manageHomeworkService.getStudentHomeworks(homeworkId);
				
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("studentHomeworks", studentHomeworks);
		
	
		String packagePath = manageHomeworkService.zipStudentHomeworks(homeworkId);
		
		result.put("packagePath", packagePath);
		
		return result;
	}
	
	


	
	@RequestMapping(value = "/teacher/student_homework/{studentHomeworkId}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> updateStudentHomeworkScore(@PathVariable("studentHomeworkId") Integer studentHomeworkId,
			@RequestParam Integer score) {

		StudentHomework studentHomework = new StudentHomework();
		studentHomework.setId(studentHomeworkId);
		studentHomework.setScore(score);
		
		Map<String, Object> result = new HashMap<String, Object>();
		if( null == manageStudentHomeworkService.updateScore(studentHomework)){
			result.put("success", "false");
			return result;
		}
		

		result.put("success", "true");
		
		return result;
	}
	
	//获得教师的所有作业
	@RequestMapping(value = "/teacher/teacher_homework/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllHomeworks() {
		
		Integer teacherId = (Integer)session.getAttribute("id");
		
		List<Homework> homeworks = ManageteacherService.getHomeworks(teacherId);
				
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(homeworks.size() == 0){
			result.put("success", "false");
		}
		else{
			result.put("success", "true");
			result.put("studentHomeworks", homeworks);
		}
		return result;
	}

}
