package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.StudentHomeworkJpaRepository;
import com.fiverings.homeworkweb.model.StudentHomework;

@Service("manageStudentHomeworkService")
public class ManageStudentHomeworkServiceImpl implements ManageStudentHomeworkService{
	@Resource
	private StudentHomeworkJpaRepository studentHomeworkJpaRepository;


	public StudentHomework updateScore(StudentHomework studentHomework) {
		StudentHomework persistStudentHomework = studentHomeworkJpaRepository.findOne(studentHomework.getId());
		persistStudentHomework.setScore(studentHomework.getScore());
		return studentHomeworkJpaRepository.save(persistStudentHomework);
	}
	
	
}
