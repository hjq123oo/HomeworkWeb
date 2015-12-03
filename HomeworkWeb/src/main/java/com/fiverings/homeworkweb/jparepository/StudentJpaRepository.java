package com.fiverings.homeworkweb.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiverings.homeworkweb.model.Student;

public interface StudentJpaRepository extends JpaRepository<Student,Long>{

}
