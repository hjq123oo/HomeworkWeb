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
@Table(name = "notice")

public class Notice implements Serializable{
	private static final long serialVersionUID = 6698666160093244248L;

	@Id @Column(name="notice_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer noticeId;
	
	private String title;
	


	private String content;
	
	@Column(name="start_time")
	private  Date startTime;
	
	@ManyToOne(targetEntity=Course.class)
	@JoinColumn(name="course_id" , referencedColumnName="course_id",nullable=false)
	private Course course;
	
	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


		
	
}
