package com.fiverings.homeworkweb.service;

import java.util.List;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Student;

public interface ManageStudentService {
	Student create(Student student);
	
	Student updateInfo(Student student);
	
	Student updatePwd(Student student);
	
	Student addCourse(Integer studentId,Integer courseId);
	
	List<Course> getCourses(Integer studentId);
	
	List<Student> getAllStudents();
}
