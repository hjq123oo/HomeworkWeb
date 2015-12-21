package com.fiverings.homeworkweb.service;

import java.util.ArrayList;
import java.util.Iterator;
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
		Homework returnHomework = new Homework();
		
		Homework homework = homeworkJpaRepository.findOne(homeworkId);
		
		returnHomework.setHomeworkId(homework.getHomeworkId());
		returnHomework.setName(homework.getName());
		returnHomework.setStartTime(homework.getStartTime());
		returnHomework.setEndTime(homework.getEndTime());
		returnHomework.setContent(homework.getContent());
		returnHomework.setFilePath(homework.getFilePath());
		
		return returnHomework;
	}



	@Transactional
	public List<StudentHomework> getStudentHomeworks(Integer homeworkId) {
		
		List<StudentHomework> studentHomeworks = homeworkJpaRepository.findOne(homeworkId).getStudentHomeworks();
		
		List<StudentHomework> returnStudentHomeworks = new ArrayList<StudentHomework>();
		
		Iterator<StudentHomework> it = studentHomeworks.iterator();
		
		while(it.hasNext()){
			returnStudentHomeworks.add(it.next());
		}
		
		return returnStudentHomeworks;
	}



	
	
	
}
