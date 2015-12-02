package com.fiverings.homeworkweb.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fiverings.homeworkweb.jparepository.UserJpaRepository;
import com.fiverings.homeworkweb.model.User;


@Service("manageUserService")
public class ManageUserServiceImpl implements ManageUserService{

	@Resource
	private UserJpaRepository userJpaRepository;
	
	
	public User create(User user) {
		return userJpaRepository.save(user);
	}
	
}
