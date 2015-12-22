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
import com.fiverings.homeworkweb.model.Teacher;

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
			studentHomework.setSubmitNum(0);
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

	@Transactional
	public List<StudentHomework> getStudentHomeworks(Integer studentId) {
		
		List<StudentHomework> studentHomeworks = studentJpaRepository.findOne(studentId).getStudentHomeworks();
		
		List<StudentHomework> returnStudentHomeworks = new ArrayList<StudentHomework>();
		
		
		Iterator<StudentHomework> it = studentHomeworks.iterator();
		
		while(it.hasNext()){
			StudentHomework returnStudentHomework = new StudentHomework();
			StudentHomework studentHomework = it.next();
			
			returnStudentHomework.setId(studentHomework.getId());
			returnStudentHomework.setScore(studentHomework.getScore());
			returnStudentHomework.setSubmitNum(studentHomework.getSubmitNum());
			returnStudentHomework.setSubmitTime(studentHomework.getSubmitTime());
			returnStudentHomework.setFilePath(studentHomework.getFilePath());
			
			
			Homework returnHomework = new Homework();
			Homework homework = studentHomework.getHomework();
			returnHomework.setHomeworkId(homework.getHomeworkId());
			returnHomework.setName(homework.getName());
			returnHomework.setStartTime(homework.getStartTime());
			returnHomework.setEndTime(homework.getEndTime());
			returnHomework.setSubmitStudentNum(homework.getSubmitStudentNum());
			returnHomework.setContent(homework.getContent());
			returnStudentHomework.setHomework(returnHomework);
			
		
			returnStudentHomeworks.add(returnStudentHomework);
		}
		
		return returnStudentHomeworks;
	}
	
	
}
