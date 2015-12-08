  package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.NoticeJpaRepository;
import com.fiverings.homeworkweb.model.Notice;


@Service("manageNoticeService")
public class ManageNoticeServiceImpl implements ManageNoticeService{

	@Resource
	private NoticeJpaRepository noticeJpaRepository;
	
	
	public Notice create(Notice notice) {
		return noticeJpaRepository.save(notice);
	}
	
}
