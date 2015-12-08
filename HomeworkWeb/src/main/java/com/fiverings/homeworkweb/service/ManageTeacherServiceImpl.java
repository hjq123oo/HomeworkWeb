package com.fiverings.homeworkweb.service;

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

	
	public Teacher getTeacher(Integer teacherId) {
		return teacherJpaRepository.findOne(teacherId);
	}


	
	public Teacher updateInfo(Teacher teacher) {
		Teacher persistTeacher = teacherJpaRepository.getOne(teacher.getTeacherId());
		
		persistTeacher.setEmail(teacher.getEmail());
		persistTeacher.setPhone(teacher.getPhone());
		persistTeacher.setRealname(teacher.getRealname());
		persistTeacher.setSchool(teacher.getSchool());
		persistTeacher.setTeacherNO(teacher.getTeacherNO());
		
		return teacherJpaRepository.save(persistTeacher);
	}


	
	public Teacher updatePwd(Teacher teacher) {
		Teacher persistTeacher = teacherJpaRepository.getOne(teacher.getTeacherId());
		
		persistTeacher.setPwd(teacher.getPwd());
		
		return teacherJpaRepository.save(persistTeacher);
	}

	
	public List<Course> getCourses(Integer teacherId) {
		return teacherJpaRepository.getOne(teacherId).getCourses();
	}
	
	
	public Course addCourse(Integer teacherId,Course course){
		course.setTeacher(teacherJpaRepository.findOne(teacherId));
		return courseJpaRepository.save(course);
	}
	
	
}
