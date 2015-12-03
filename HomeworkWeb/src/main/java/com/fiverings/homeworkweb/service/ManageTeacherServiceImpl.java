package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.TeacherJpaRepository;
import com.fiverings.homeworkweb.model.Teacher;

@Service("manageTeacherService")
public class ManageTeacherServiceImpl implements ManageTeacherService{

	@Resource
	private TeacherJpaRepository teacherJpaRepository;
	
	public Teacher create(Teacher teacher) {
		return teacherJpaRepository.save(teacher);
	}

}
