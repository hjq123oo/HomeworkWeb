package com.fiverings.homeworkweb.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageHomeworkService;
import com.fiverings.homeworkweb.service.ManageStudentHomeworkService;



@Controller
public class HomeworkController {

	@Resource
	ManageCourseService manageCourseService;
	
	@Resource
	ManageHomeworkService manageHomeworkService;
	
	@Resource
	ManageStudentHomeworkService manageStudentHomeworkService;

	@Resource
	HttpServletRequest request;
	
	@RequestMapping(value = "/homeworkList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> homeworkList(@RequestParam("courseId") String strCourseId) {
		Integer courseId = Integer.parseInt(strCourseId);

		
		List<Homework> homeworks = manageCourseService.getHomeworks(courseId);
		

		Map<String, String> result = new HashMap<String, String>();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		for (Homework homework : homeworks) {
			result.put("id", ""+homework.getHomeworkId());
			result.put("name", homework.getName());
			result.put("startTime", sdf.format(homework.getStartTime()));
			result.put("endTime",  sdf.format(homework.getEndTime()));
			

		}

		return result;
	}
	
	
	
	@RequestMapping(value = "/homeworkDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> homeworkDetail(@RequestParam("homeworkId") String strHomeworkId) {
		Integer homeworkId = Integer.parseInt(strHomeworkId);

		Homework homework = manageHomeworkService.getHomework(homeworkId);
		
		

		Map<String, String> result = new HashMap<String, String>();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		
		result.put("id", ""+homework.getHomeworkId());
		result.put("name", homework.getName());
		result.put("content", homework.getContent());
		result.put("endTime",  sdf.format(homework.getEndTime()));
			

		

		return result;
	}
	
	
	@RequestMapping(value = "/correct", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> correct(@RequestParam("homeworkId") String strHomeworkId) {
		Integer homeworkId = Integer.parseInt(strHomeworkId);

		Homework homework = manageHomeworkService.getHomework(homeworkId);
		
		List<StudentHomework> studentHomeworks = homework.getStudentHomeworks();
		
		

		Map<String, String> result = new HashMap<String, String>();

		for(StudentHomework studentHomework : studentHomeworks){
			Student student = studentHomework.getStudent();
			result.put("studentId", ""+student.getStudentId());
			result.put("homeworkId", strHomeworkId);
			result.put("studentNO",student.getStudentNO());
			result.put("name",student.getStudentNO());
			result.put("college",student.getCollege());
			result.put("className",student.getClassName());
			
		}

		

		return result;
	}
	
	
	@RequestMapping(value = "/saveCorrect", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveCorrect(@RequestParam("homeworkId") String strHomeworkId) {
		Integer homeworkId = Integer.parseInt(strHomeworkId);
		
		Homework homework = manageHomeworkService.getHomework(homeworkId);
		List<StudentHomework> studentHomeworks = homework.getStudentHomeworks();
		
		
		int size = studentHomeworks.size();
		
		for(int i=0;i<size;i++){
			studentHomeworks.get(i).setScore(Integer.parseInt(request.getParameter("score"+i)));
			manageStudentHomeworkService.updateScore(studentHomeworks.get(i));
		}
		
		

		Map<String, String> result = new HashMap<String, String>();

		result.put("successful", "true");
		
		return result;
	}
}
