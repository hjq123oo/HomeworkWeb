package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
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
	
	@ManyToOne(targetEntity=Course.class)
	@JoinColumn(name="course_id" , referencedColumnName="course_id",nullable=false)
	private Integer courseId;
	
    @ManyToMany(targetEntity=Student.class)
    @JoinTable(name="student_homework",
    	joinColumns=@JoinColumn(name="homework_id",referencedColumnName="homework_id"),
    	inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id")
    )
    private List<Student> students = new ArrayList<>();
	
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

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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
