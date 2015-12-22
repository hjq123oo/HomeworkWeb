package com.fiverings.homeworkweb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fiverings.homeworkweb.model.StudentHomework;

public interface ManageStudentHomeworkService {
	StudentHomework getStudentHomework(Integer studentId,Integer homeworkId);
	
	StudentHomework updateScore(StudentHomework studentHomework);
	
	StudentHomework uploadStudentHomework(Integer studentId, Integer homeworkId, MultipartFile file);
	
	List<String> getAllStudentHomwrokFilePath(Integer studentId, Integer homeworkId);
	
}
