package com.fiverings.homeworkweb.service;

import com.fiverings.homeworkweb.model.StudentHomework;

public interface ManageStudentHomeworkService {
	StudentHomework getStudentHomework(Integer studentId,Integer homeworkId);
	
	StudentHomework updateScore(StudentHomework studentHomework);
}
