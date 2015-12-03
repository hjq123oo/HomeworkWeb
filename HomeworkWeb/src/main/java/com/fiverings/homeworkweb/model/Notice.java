package com.fiverings.homeworkweb.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "notice")

public class Notice implements Serializable{
	private static final long serialVersionUID = 6698666160093244248L;

	@Id @Column(name="notice_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long noticeId;
	
	private String title;
	
	private String content;
	
	@Column(name="start_time")
	private Timestamp startTime;
	
	
	public Long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Long noticeId) {
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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


		
	
}
