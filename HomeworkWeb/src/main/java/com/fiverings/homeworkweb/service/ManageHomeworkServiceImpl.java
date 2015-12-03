package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.HomeworkJpaRepository;
import com.fiverings.homeworkweb.model.Homework;

@Service("manageHomeworkService")
public class ManageHomeworkServiceImpl implements ManageHomeworkService{
	
	@Resource
	private HomeworkJpaRepository homeworkJpaRepository;

	
	public Homework create(Homework homework) {
		return homeworkJpaRepository.save(homework);
	}
	
	
}
