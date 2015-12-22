package com.fiverings.homeworkweb.service;

import java.util.List;

import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.Teacher;

public interface ManageTeacherService {
	Teacher create(Teacher teacher);
	
	Teacher getTeacher(Integer teacherId);
	
	Teacher updateInfo(Teacher teacher);
	
	Teacher updatePwd(Teacher teacher);
	
	List<Course> getCourses(Integer teacherId);
	
	Course addCourse(Integer teacherId,Course course);
	
	List<Teacher> getAllTeachers();
	
	List<Homework> getHomeworks(Integer teacherId);
}
