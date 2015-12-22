package com.fiverings.homeworkweb.service;

import java.util.List;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;

public interface ManageStudentService {
	Student create(Student student);
	
	Student updateInfo(Student student);
	
	Student updatePwd(Student student);
	
	Student getStudent(Integer studentId);
	
	Student addCourse(Integer studentId,Integer courseId);
	
	List<Course> getCourses(Integer studentId);
	
	List<Student> getAllStudents();
	
	List<Homework> getRestStudentHomeworks(Integer studentId);
	
	List<StudentHomework> getStudentHomeworks(Integer studentId,Integer courseId);
}
