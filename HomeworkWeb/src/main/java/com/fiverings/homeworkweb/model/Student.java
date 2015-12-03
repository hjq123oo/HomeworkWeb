package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "student")
public class Student implements Serializable{
	
	@Id @Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long studentId;
	
	private String name;
	
	private String pwd;
    
    private String school;
	
    private String college;
    
    @Column(name="class_name")
    private String className;
    
    @Column(name="student_no")
    private String studentNO;
    
    private String realname;
    
    private String email;
    
    private String phone;
    
    @Column(name="file_path")
    private String filePath;

    @ManyToMany(targetEntity=Course.class)
    @JoinTable(name="student_course",
    	joinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id"),
    	inverseJoinColumns=@JoinColumn(name="course_id",referencedColumnName="course_id")
    )
    private List<Course> courses = new ArrayList<>();
    
    @ManyToMany(targetEntity=Homework.class)
    @JoinTable(name="student_homework",
    	joinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id"),
    	inverseJoinColumns=@JoinColumn(name="homework_id",referencedColumnName="homework_id")
    )
    private List<Course> homeworks = new ArrayList<>();
    
}
