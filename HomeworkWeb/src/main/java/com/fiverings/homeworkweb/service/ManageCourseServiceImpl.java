package com.fiverings.homeworkweb.service;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	@Transactional
	public List<Homework> getHomeworks(Integer courseId){
		List<Homework> homeworks = courseJpaRepository.findOne(courseId).getHomeworks();
		
		Iterator<Homework> it = homeworks.iterator();
		
		List<Homework> returnHomework = new ArrayList<Homework>();
		
		while(it.hasNext()){
			returnHomework.add(it.next());
		}
	
		return returnHomework;
		
	}

	@Transactional
	public Homework addHomework(Integer courseId, Homework homework) {
		Course course = courseJpaRepository.findOne(courseId);
		homework.setCourse(course);
		homeworkJpaRepository.save(homework);
		
		List<Student> students = course.getStudents();
		
		Iterator<Student> it = students.iterator();
		
		while(it.hasNext()){
			StudentHomework studentHomework = new StudentHomework();
			studentHomework.setStudent(it.next());
			studentHomework.setHomework(homework);
			studentHomeworkJpaRepository.save(studentHomework);
		}
		
		return homework;
	}
	
	
}
