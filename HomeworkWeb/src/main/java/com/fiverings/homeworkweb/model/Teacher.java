package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "teacher")
public class Teacher implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String pwd;
    
    private String school;
    
    private String teacherNO;
    
    private String realName;
    
    private String email;
    
    private String phone;
    
    private String filePath;
    

	@OneToMany(targetEntity=Course.class,mappedBy="teacher")
	private List<Course> courses = new ArrayList<>();
    
}
