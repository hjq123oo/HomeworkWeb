package com.fiverings.homeworkweb.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiverings.homeworkweb.model.Course;

public interface CourseJpaRepository extends JpaRepository<Course, Integer>{
	
}
