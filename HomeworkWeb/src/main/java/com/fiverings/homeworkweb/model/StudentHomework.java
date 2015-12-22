package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_homework")
public class StudentHomework implements Serializable{

	private static final long serialVersionUID = 2724645944088369186L;
	
	@Id @Column(name="student_homework_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	Integer score;
	
	@Column(name="file_path")
	String filePath;
	
	@ManyToOne(targetEntity=Student.class)
	@JoinColumn(name="student_id" , referencedColumnName="student_id",nullable=false)
	private Student student;
	
	
	@ManyToOne(targetEntity=Homework.class)
	@JoinColumn(name="homework_id" , referencedColumnName="homework_id",nullable=false)
	private Homework homework;
	
	@Column(name="submit_num",nullable=false,columnDefinition = "int default 0")
	Integer submitNum;
	
	@Column(name="submit_time")
	private Date submitTime;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Homework getHomework() {
		return homework;
	}


	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public Integer getSubmitNum() {
		return submitNum;
	}


	public void setSubmitNum(Integer submitNum) {
		this.submitNum = submitNum;
	}

	public Date getSubmitTime() {
		return submitTime;
	}


	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
}
