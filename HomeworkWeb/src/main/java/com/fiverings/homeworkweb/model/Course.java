package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable{
	private static final long serialVersionUID = -2583801459718005437L;

	@Id @Column(name="course_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long courseId;
	
	private String name;
	
	private String number;
	
	private String time;
	
	private String place;
	
	private String college;
	
	private String specialty;
	
	private String introduction;
	
	@Column(name="start_time")
	private Date startTime;

	@Column(name="end_time")
	private Date endTime;
	
	@Column(name="file_path")
	private String filePath;
	
	@ManyToOne(targetEntity=Teacher.class)
	@JoinColumn(name="teacher_id" , referencedColumnName="teacher_id",nullable=false)
	private Long teacherId;
	
	@OneToMany(targetEntity=Homework.class,mappedBy="courseId")
	private List<Homework> homeworks = new ArrayList<>();
	
    @ManyToMany(targetEntity=Student.class)
    @JoinTable(name="student_course",
    	joinColumns=@JoinColumn(name="course_id",referencedColumnName="course_id"),
    	inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id")
    )
    private List<Student> students = new ArrayList<>();
    
    @OneToMany(targetEntity=Notice.class,mappedBy="courseId")
	private List<Notice> notices = new ArrayList<>();
    
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public List<Homework> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}

