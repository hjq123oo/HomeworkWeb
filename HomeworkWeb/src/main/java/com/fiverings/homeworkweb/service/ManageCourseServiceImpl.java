package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.CourseJpaRepository;
import com.fiverings.homeworkweb.model.Course;

@Service("manageCourseService")
public class ManageCourseServiceImpl implements ManageCourseService{
	
	@Resource
	private CourseJpaRepository courseJpaRepository;
	
	
	public Course create(Course course) {
		return courseJpaRepository.save(course);
	}


	
	public Course getCourse(Integer courseId) {
		return courseJpaRepository.findOne(courseId);
	}
}
