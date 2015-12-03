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
	
	
	@Id @Column(name="notice_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long noticeId;
	
	private String title;
	
	private String content;
	
	@Column(name="start_time")
	private Timestamp startTime;
		
	
}
