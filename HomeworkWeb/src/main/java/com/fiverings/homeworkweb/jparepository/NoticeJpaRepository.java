package com.fiverings.homeworkweb.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiverings.homeworkweb.model.Notice;


public interface NoticeJpaRepository extends JpaRepository<Notice, Integer>{

}