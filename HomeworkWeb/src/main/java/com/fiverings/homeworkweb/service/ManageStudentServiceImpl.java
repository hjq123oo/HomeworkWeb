package com.fiverings.homeworkweb.service;

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

	public Student updatePwd(Student student) {
		Student persistStudent = studentJpaRepository.findOne(student.getStudentId());

		persistStudent.setPwd(student.getPwd());

		return studentJpaRepository.save(persistStudent);

	}

	/*
	 * ����ѧ��id��ѧ������γ�
	 * 
	 * @param student_id Ҫ����γ̵�ѧ����id
	 * 
	 * @param course_id ����Ŀγ�id
	 * 
	 * @return Student ���ر��޸ĵ�ѧ��
	 */

	public Student addCourse(Integer studentId, Integer courseId) {
		Student student = studentJpaRepository.findOne(studentId);

		Course course = courseJpaRepository.findOne(courseId);

		student.getCourses().add(course);

		List<Homework> homeworks = course.getHomeworks();

		int size = homeworks.size();
		for (int i = 0; i < size; i++) {
			StudentHomework studentHomework = new StudentHomework();
			studentHomework.setStudent(student);
			studentHomework.setHomework(homeworks.get(i));
			studentHomeworkJpaRepository.save(studentHomework);
		}

		return studentJpaRepository.save(student);
	}

	/*
	 * ����ѧ��id�õ��γ��б�
	 * 
	 * @param studentId ѧ����id
	 * 
	 * @return List ���ؿγ��б�
	 */
	public List<Course> getCourses(Integer studentId) {
		return studentJpaRepository.findOne(studentId).getCourses();

	}

}
