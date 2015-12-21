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

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.service.ManageCourseService;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@Controller
public class TeacherCourseController {
	@Resource
	private ManageTeacherService manageTeacherService;
	
	@Resource
	private ManageCourseService manageCourseService;
	
	@Resource
	private HttpSession session;

	@RequestMapping(value = "/teacher/course/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Course>> getAllTeacherCourse() {
		Integer teacherId = (Integer)session.getAttribute("id");
		Map<String, List<Course>> result = new HashMap<String, List<Course>>();

		List<Course> courses = manageTeacherService.getCourses(teacherId);
	
		result.put("courses", courses);
		
		return result;
	}

	
	@RequestMapping(value = "/teacher/course/{courseId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTeacherCourse(@PathVariable Integer courseId) {
		
		Course course = manageCourseService.getCourse(courseId);
		
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("course", course);
		
		return result;
	}
	
	
	@RequestMapping(value = "/teacher/course/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addCourse(
			@RequestParam("school") String school,
			@RequestParam("college") String college,
			@RequestParam("name") String name,
			@RequestParam("number") String number,
			@RequestParam("specialty") String specialty,
			@RequestParam("introduction") String introduction,
			@RequestParam("time") String time,
			@RequestParam("place") String place,
			@RequestParam("lateInterval") String strLateInterval,
			@RequestParam("latePercent") String strLatePercent,
			@RequestParam("endTime") String strEndTime){
		
		
		Integer teacherId = (Integer)session.getAttribute("id");
		
		Integer lateInterval = Integer.parseInt(strLateInterval);
		Integer latePercent = Integer.parseInt(strLatePercent);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm"); 
		
		Date endTime = null;
		try {
			endTime = sdf.parse(strEndTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Course course = new Course();
		course.setSchool(school);
		course.setCollege(college);
		course.setEndTime(endTime);
		course.setIntroduction(introduction);
		course.setLateInterval(lateInterval);
		course.setLatePercent(latePercent);
		course.setName(name);
		course.setNumber(number);
		course.setPlace(place);
		course.setSpecialty(specialty);
		course.setStartTime(new Date());
		course.setTime(time);
		
		
		manageTeacherService.addCourse(teacherId, course);
		
		Map<String, String> result = new HashMap<String, String>();

		result.put("success", "true");
		
		return result;
	}

	
	
	
}
