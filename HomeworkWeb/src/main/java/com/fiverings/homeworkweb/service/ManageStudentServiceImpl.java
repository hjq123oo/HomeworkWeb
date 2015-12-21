package com.fiverings.homeworkweb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiverings.homeworkweb.jparepository.CourseJpaRepository;
import com.fiverings.homeworkweb.jparepository.StudentHomeworkJpaRepository;
import com.fiverings.homeworkweb.jparepository.StudentJpaRepository;
import com.fiverings.homeworkweb.model.Course;
import com.fiverings.homeworkweb.model.Homework;
import com.fiverings.homeworkweb.model.Student;
import com.fiverings.homeworkweb.model.StudentHomework;

@Service("manageStudentService")
public class ManageStudentServiceImpl implements ManageStudentService {

	@Resource
	private StudentJpaRepository studentJpaRepository;

	@Resource
	private CourseJpaRepository courseJpaRepository;

	@Resource
	private StudentHomeworkJpaRepository studentHomeworkJpaRepository;

	public List<Student> getAllStudents(){
		return studentJpaRepository.findAll();
	}
	
	public Student create(Student student) {
		return studentJpaRepository.save(student);
	}

	public Student updateInfo(Student student) {
		Student persistStudent = studentJpaRepository.findOne(student.getStudentId());

		persistStudent.setClassName(student.getClassName());
		persistStudent.setCollege(student.getCollege());
		persistStudent.setEmail(student.getEmail());
		persistStudent.setPhone(student.getPhone());
		persistStudent.setRealname(student.getRealname());
		persistStudent.setSchool(student.getSchool());
		persistStudent.setStudentNO(student.getStudentNO());

		return studentJpaRepository.save(persistStudent);

	}
	
	public Student getStudent(Integer studentId) {
		Student student = studentJpaRepository.findOne(studentId);
		
		Student returnStudent = new Student();
		
		returnStudent.setStudentId(studentId);
		returnStudent.setName(student.getName());
		returnStudent.setPwd(student.getPwd());
		returnStudent.setSchool(student.getSchool());
		returnStudent.setCollege(student.getCollege());
		returnStudent.setClassName(student.getClassName());
		returnStudent.setStudentNO(student.getStudentNO());
		returnStudent.setRealname(student.getRealname());
		returnStudent.setEmail(student.getEmail());
		returnStudent.setPhone(student.getPhone());
		
		return returnStudent;
	}

	public Student updatePwd(Student student) {
		Student persistStudent = studentJpaRepository.findOne(student.getStudentId());

		persistStudent.setPwd(student.getPwd());

		return studentJpaRepository.save(persistStudent);

	}

	/*
	 * 学生加入课程
	 * 
	 * @param student_id 学生id
	 * 
	 * @param course_id 要加入课程的id
	 * 
	 * @return Student 返回被修改的学生
	 */
	@Transactional
	public Student addCourse(Integer studentId, Integer courseId) {
		Student student = studentJpaRepository.findOne(studentId);

		Course course = courseJpaRepository.findOne(courseId);

		student.getCourses().add(course);

		course.setStudentNum(course.getStudentNum()+1);
		
		List<Homework> homeworks = course.getHomeworks();

		Iterator<Homework> it = homeworks.iterator();
		
		while(it.hasNext()){
			StudentHomework studentHomework = new StudentHomework();
			studentHomework.setStudent(student);
			studentHomework.setHomework(it.next());
			studentHomeworkJpaRepository.save(studentHomework);
		}
		
		courseJpaRepository.save(course);
		return studentJpaRepository.save(student);
	}

	/*
	 * 得到学生参加的所有课程
	 * 
	 * @param studentId 学生的id
	 * 
	 * @return List 返回的课程列表
	 */
	@Transactional
	public List<Course> getCourses(Integer studentId) {
		List<Course> courses = studentJpaRepository.findOne(studentId).getCourses();
		
		List<Course> returnCourses = new ArrayList<Course>();
		
		Iterator<Course> it = courses.iterator();
		while(it.hasNext()){
			returnCourses.add(it.next());
		}
		
		return returnCourses;
	}

}
