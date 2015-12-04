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
	private static final long serialVersionUID = 1632712622140728756L;

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
    private List<Homework> homeworks = new ArrayList<>();
    
    
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStudentNO() {
		return studentNO;
	}

	public void setStudentNO(String studentNO) {
		this.studentNO = studentNO;
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

	public List<Homework> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}
