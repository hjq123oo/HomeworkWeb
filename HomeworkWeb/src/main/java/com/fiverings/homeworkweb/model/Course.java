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
	
	@OneToMany(targetEntity=Homework.class,mappedBy="course")
	private List<Homework> homeworks = new ArrayList<>();
	
    @ManyToMany(targetEntity=Student.class)
    @JoinTable(name="student_course",
    	joinColumns=@JoinColumn(name="course_id",referencedColumnName="course_id"),
    	inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id")
    )
    private List<Course> students = new ArrayList<>();
}

