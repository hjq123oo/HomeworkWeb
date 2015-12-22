package com.fiverings.homeworkweb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;

public interface ManageCourseService {
	
	Course getCourse(Integer courseId);
	
	List<Homework> getHomeworks(Integer courseId);
	
	Homework addHomework(Integer courseId,Homework homework);
	
	Homework addHomework(Integer courseId, Homework homework,MultipartFile file);
	/*Integer getStudentNum(Integer courseId);*/
}