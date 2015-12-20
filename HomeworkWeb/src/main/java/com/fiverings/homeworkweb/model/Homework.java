package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "homework")
public class Homework implements Serializable{

	private static final long serialVersionUID = -3598183672399456282L;

	@Id @Column(name="homework_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer homeworkId;
	
	private String name;
	
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	private Date endTime;
	
	private String content;
	
	@Column(name="file_path")
	private String filePath;
	
	@Column(name="submit_student_num",nullable=false,columnDefinition = "int default 0")
	private Integer submitStudentNum;
	
	public Integer getSubmitStudentNum() {
		return submitStudentNum;
	}

	public void setSubmitStudentNum(Integer submitStudentNum) {
		this.submitStudentNum = submitStudentNum;
	}

	@ManyToOne(targetEntity=Course.class)
	@JoinColumn(name="course_id" , referencedColumnName="course_id",nullable=false)
	private Course course;
	
	
	@OneToMany(targetEntity=StudentHomework.class,mappedBy="homework")
	private List<StudentHomework> studentHomeworks = new ArrayList<>();
   
	
	public Integer getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}



	public List<StudentHomework> getStudentHomeworks() {
		return studentHomeworks;
	}

	public void setStudentHomeworks(List<StudentHomework> studentHomeworks) {
		this.studentHomeworks = studentHomeworks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
