package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.StudentJpaRepository;
import com.fiverings.homeworkweb.model.Student;

@Service("manageStudentService")
public class ManageStudentServiceImpl implements ManageStudentService{

	@Resource
	private StudentJpaRepository studentJpaRepository;
	
	public Student create(Student student) {
		
		return studentJpaRepository.save(student);
	}

}
