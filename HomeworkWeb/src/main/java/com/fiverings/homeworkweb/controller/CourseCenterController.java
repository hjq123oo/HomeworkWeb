package com.fiverings.homeworkweb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.service.ManageTeacherService;

@Controller
public class CourseCenterController {

	@Resource
	ManageTeacherService manageTeacherService;
	


	@RequestMapping(value = "/teacherCourseCenter", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> courseCenter(@RequestParam("teacherId") String strTeacherId) {
		Integer teacherId = Integer.parseInt(strTeacherId);

		List<Course> courses = manageTeacherService.getCourses(teacherId);

		Map<String, String> result = new HashMap<String, String>();

		for (Course course : courses) {
			result.put("name", course.getName());
			result.put("number", course.getNumber());
			result.put("teacher", course.getTeacher().getRealname());
			result.put("time", course.getTime());
			result.put("place", course.getPlace());

		}

		return result;
	}

	@RequestMapping(value = "/createCourse", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> createCourse(@RequestParam("teacherId") String strTeacherId,
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
		
		Integer teacherId = Integer.parseInt(strTeacherId);
		Integer lateInterval = Integer.parseInt(strLateInterval);
		Integer latePercent = Integer.parseInt(strLatePercent);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		
		Date endTime = null;
		try {
			endTime = sdf.parse(strEndTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Course course = new Course();
		course.setCollege(college);
		course.setEndTime(endTime);
		course.setFilePath("123");
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

		result.put("successful", "true");
		
		return result;
	}

	


}
