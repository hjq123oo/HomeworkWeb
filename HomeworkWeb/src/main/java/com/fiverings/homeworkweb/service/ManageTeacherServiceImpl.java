package com.fiverings.homeworkweb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiverings.homeworkweb.jparepository.CourseJpaRepository;
import com.fiverings.homeworkweb.jparepository.TeacherJpaRepository;
import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Teacher;

@Service("manageTeacherService")
public class ManageTeacherServiceImpl implements ManageTeacherService{

	@Resource
	private TeacherJpaRepository teacherJpaRepository;
	
	@Resource
	private CourseJpaRepository courseJpaRepository;
	
	public Teacher create(Teacher teacher) {
		return teacherJpaRepository.save(teacher);
	}

	public List<Teacher> getAllTeachers(){
		return teacherJpaRepository.findAll();
	}
	
	public Teacher getTeacher(Integer teacherId) {
		Teacher teacher =  teacherJpaRepository.findOne(teacherId);
		
		Teacher returnTeacher = new Teacher();
		returnTeacher.setTeacherId(teacher.getTeacherId());
		returnTeacher.setName(teacher.getName());
		returnTeacher.setPwd(teacher.getPwd());
		returnTeacher.setSchool(teacher.getSchool());
		returnTeacher.setTeacherNO(teacher.getTeacherNO());
		returnTeacher.setRealname(teacher.getRealname());
		returnTeacher.setEmail(teacher.getEmail());
		returnTeacher.setPhone(teacher.getPhone());
		
		
		return returnTeacher;
	}

	public Teacher updateInfo(Teacher teacher) {
		Teacher persistTeacher = teacherJpaRepository.findOne(teacher.getTeacherId());
		
		persistTeacher.setEmail(teacher.getEmail());
		persistTeacher.setPhone(teacher.getPhone());
		persistTeacher.setRealname(teacher.getRealname());
		persistTeacher.setSchool(teacher.getSchool());
		persistTeacher.setTeacherNO(teacher.getTeacherNO());
		
		return teacherJpaRepository.save(persistTeacher);
	}
	
	public Teacher updatePwd(Teacher teacher) {
		Teacher persistTeacher = teacherJpaRepository.findOne(teacher.getTeacherId());
		
		persistTeacher.setPwd(teacher.getPwd());
		
		return teacherJpaRepository.save(persistTeacher);
	}

	@Transactional
	public List<Course> getCourses(Integer teacherId) {
	
		List<Course> courses = teacherJpaRepository.findOne(teacherId).getCourses();
		
		List<Course> returnCourses = new ArrayList<Course>();
		
		Iterator<Course> it = courses.iterator();
		while(it.hasNext()){
			Course returnCourse = new Course();
			Course course = it.next();
			returnCourse.setCourseId(course.getCourseId());
			returnCourse.setName(course.getName());
			returnCourse.setNumber(course.getNumber());
			returnCourse.setTime(course.getTime());
			returnCourse.setPlace(course.getPlace());
			Teacher teacher = new Teacher();
			teacher.setRealname(course.getTeacher().getRealname());
			returnCourse.setTeacher(teacher);
		
			returnCourses.add(returnCourse);
		}
	
		return returnCourses;
	}
	
	
	public Course addCourse(Integer teacherId,Course course){
		course.setTeacher(teacherJpaRepository.findOne(teacherId));
		return courseJpaRepository.save(course);
	}
	
	
}
