package com.fiverings.homeworkweb.service;

import java.util.List;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;

public interface ManageCourseService {
	
	Course getCourse(Integer courseId);
	
	List<Homework> getHomeworks(Integer courseId);
	
	Homework addHomework(Integer courseId,Homework homework);
	
	/*Integer getStudentNum(Integer courseId);*/
}