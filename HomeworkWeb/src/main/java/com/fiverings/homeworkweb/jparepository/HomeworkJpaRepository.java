package com.fiverings.homeworkweb.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiverings.homeworkweb.model.Homework;

public interface HomeworkJpaRepository extends JpaRepository<Homework, Integer>{

}
