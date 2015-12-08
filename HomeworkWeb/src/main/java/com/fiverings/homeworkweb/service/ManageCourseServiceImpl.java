package com.fiverings.homeworkweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiverings.homeworkweb.jparepository.CourseJpaRepository;
import com.fiverings.homeworkweb.jparepository.HomeworkJpaRepository;
import com.fiverings.homeworkweb.jparepository.StudentHomeworkJpaRepository;
import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;

@Service("manageCourseService")
public class ManageCourseServiceImpl implements ManageCourseService{
	
	@Resource
	private CourseJpaRepository courseJpaRepository;

	@Resource
	private HomeworkJpaRepository homeworkJpaRepository;
	
	@Resource
	private StudentHomeworkJpaRepository studentHomeworkJpaRepository;
	
	
	public Course getCourse(Integer courseId) {
		return courseJpaRepository.findOne(courseId);
	}
	
	public List<Homework> getHomeworks(Integer courseId){
		return courseJpaRepository.findOne(courseId).getHomeworks();
	}

	@Transactional
	public Homework addHomework(Integer courseId, Homework homework) {
		Course course = courseJpaRepository.findOne(courseId);
		homework.setCourse(course);
		homeworkJpaRepository.save(homework);
		
		List<Student> students = course.getStudents();
		
		int size = students.size();
		for(int i=0;i<size;i++){
			StudentHomework studentHomework = new StudentHomework();
			studentHomework.setStudent(students.get(i));
			studentHomework.setHomework(homework);
		}
		
		return homework;
	}
	
	
}
