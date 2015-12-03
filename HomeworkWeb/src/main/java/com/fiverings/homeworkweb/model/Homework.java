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
	@Id @Column(name="homework_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long homeworkId;
	
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
	private Long courseId;
	
    @ManyToMany(targetEntity=Student.class)
    @JoinTable(name="student_homework",
    	joinColumns=@JoinColumn(name="homework_id",referencedColumnName="homework_id"),
    	inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id")
    )
    private List<Course> students = new ArrayList<>();
}
