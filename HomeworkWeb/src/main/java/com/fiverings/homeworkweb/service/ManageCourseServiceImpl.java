package com.fiverings.homeworkweb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiverings.homeworkweb.jparepository.CourseJpaRepository;
import com.fiverings.homeworkweb.jparepository.HomeworkJpaRepository;
import com.fiverings.homeworkweb.jparepository.StudentHomeworkJpaRepository;
import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;
import com.fiverings.homeworkweb.model.Teacher;

@Service("manageCourseService")
public class ManageCourseServiceImpl implements ManageCourseService{
	
	@Resource
	private CourseJpaRepository courseJpaRepository;

	@Resource
	private HomeworkJpaRepository homeworkJpaRepository;
	
	@Resource
	private StudentHomeworkJpaRepository studentHomeworkJpaRepository;
	
	@Resource
	private EntityManager em;
	
	@Transactional
	public Course getCourse(Integer courseId) {
		
		Course course = courseJpaRepository.findOne(courseId);
		
		if (course==null){
			return null;
		}
		
		Course returnCourse = new Course();
		returnCourse.setCourseId(course.getCourseId());
		
		returnCourse.setNumber(course.getNumber());
		returnCourse.setSchool(course.getSchool());
		returnCourse.setCollege(course.getCollege());
		returnCourse.setSpecialty(course.getSpecialty());
		returnCourse.setName(course.getName());
		returnCourse.setTime(course.getTime());
		returnCourse.setPlace(course.getPlace());
		returnCourse.setLateInterval(course.getLateInterval());
		returnCourse.setLatePercent(course.getLatePercent());
		returnCourse.setIntroduction(course.getIntroduction());
		returnCourse.setStudentNum(course.getStudentNum());
		
		Teacher teacher = course.getTeacher();
		Teacher returnTeacher = new Teacher();
		
		returnTeacher.setTeacherId(teacher.getTeacherId());
		returnTeacher.setRealname(teacher.getRealname());
		returnTeacher.setSchool(teacher.getSchool());
		
		returnCourse.setTeacher(returnTeacher);
		
		List<Homework> homeworks = course.getHomeworks();
		
		List<Homework> returnHomeworks = new ArrayList<Homework>();
		
		Iterator<Homework> it = homeworks.iterator();
		
		while(it.hasNext()){
			Homework returnHomework = new Homework();
			
			Homework homework = it.next();
			
			returnHomework.setHomeworkId(homework.getHomeworkId());
			returnHomework.setName(homework.getName());
			returnHomework.setStartTime(homework.getStartTime());
			returnHomework.setEndTime(homework.getEndTime());
			returnHomework.setSubmitStudentNum(homework.getSubmitStudentNum());
			returnHomeworks.add(returnHomework);
		}
		
		returnCourse.setHomeworks(returnHomeworks);
		
		return returnCourse;
	}
	
	/*
	public Integer getStudentNum(Integer courseId){
		String jpql = "select count(*) from table student_course sc where sc.course_id= :courseId";
		
		Query query = em.createQuery(jpql);  
		query.setParameter("courseId", courseId);
		return (Integer)query.getSingleResult();
	}*/
	
	
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
		homework.setSubmitStudentNum(0);
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
