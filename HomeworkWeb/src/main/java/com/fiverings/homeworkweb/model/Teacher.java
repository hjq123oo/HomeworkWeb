package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "teacher")
public class Teacher implements Serializable{
	private static final long serialVersionUID = 2664295856342100507L;

	@Id @Column(name="teacher_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer teacherId;
	
	private String name;
	
	private String pwd;
    
    private String school;
    
    private String teacherNO;
    
    private String realname;
    
    private String email;
    
    private String phone;
    
    private String filePath;
    

	@OneToMany(targetEntity=Course.class,mappedBy="teacher")
	private List<Course> courses = new ArrayList<>();
    
	


	public Integer getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public String getTeacherNO() {
		return teacherNO;
	}


	public void setTeacherNO(String teacherNO) {
		this.teacherNO = teacherNO;
	}





	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
