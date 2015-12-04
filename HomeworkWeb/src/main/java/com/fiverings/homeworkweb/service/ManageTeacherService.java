package com.fiverings.homeworkweb.service;

import com.fiverings.homeworkweb.model.Teacher;

public interface ManageTeacherService {
	Teacher create(Teacher teacher);
	
	Teacher getTeacher(Integer teacherId);
}
