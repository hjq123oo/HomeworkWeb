package com.fiverings.homeworkweb.service;

import com.fiverings.homeworkweb.model.Homework;

public interface ManageHomeworkService {
	
	Homework create(Homework homework);
	
	Homework getHomework(Integer homework_id);
}
