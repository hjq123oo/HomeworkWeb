package com.fiverings.homeworkweb.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiverings.homeworkweb.model.StudentHomework;

public interface StudentHomeworkJpaRepository extends JpaRepository<StudentHomework, Integer>{

}
