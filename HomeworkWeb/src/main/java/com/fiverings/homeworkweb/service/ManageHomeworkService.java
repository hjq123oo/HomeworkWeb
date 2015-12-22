package com.fiverings.homeworkweb.service;

import java.util.List;

import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.StudentHomework;

public interface ManageHomeworkService {
	
	Homework getHomework(Integer homeworkId);
	
	List<StudentHomework> getStudentHomeworks(Integer homeworkId); 
	
	String zipStudentHomeworks(Integer homeworkId);
}
