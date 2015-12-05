package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.StudentHomeworkJpaRepository;
import com.fiverings.homeworkweb.model.StudentHomework;

@Service("manageStudentHomeworkService")
public class ManageStudentHomeworkServiceImpl implements ManageStudentHomeworkService{
	@Resource
	private StudentHomeworkJpaRepository studentHomeworkJpaRepository;
	
	public StudentHomework create(StudentHomework studentHomework) {
		return studentHomeworkJpaRepository.save(studentHomework);
	}
}
