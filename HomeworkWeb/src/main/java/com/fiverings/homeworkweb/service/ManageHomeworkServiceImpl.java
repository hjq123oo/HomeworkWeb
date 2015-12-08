package com.fiverings.homeworkweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiverings.homeworkweb.jparepository.HomeworkJpaRepository;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.StudentHomework;

@Service("manageHomeworkService")
public class ManageHomeworkServiceImpl implements ManageHomeworkService{
	
	@Resource
	private HomeworkJpaRepository homeworkJpaRepository;



	
	public Homework getHomework(Integer homeworkId) {
		return homeworkJpaRepository.findOne(homeworkId);
	}




	public List<StudentHomework> getStudentHomeworks(Integer homeworkId) {
		return homeworkJpaRepository.findOne(homeworkId).getStudentHomeworks();
	
	}
	
	
}
