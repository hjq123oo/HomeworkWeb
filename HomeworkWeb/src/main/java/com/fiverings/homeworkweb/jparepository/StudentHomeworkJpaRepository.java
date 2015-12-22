package com.fiverings.homeworkweb.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fiverings.homeworkweb.model.StudentHomework;

public interface StudentHomeworkJpaRepository extends JpaRepository<StudentHomework, Integer>{
	@Query("FROM StudentHomework WHERE student_id = :studentId and homework_id = :homeworkId")
	public StudentHomework find(@Param("studentId") Integer studentId,@Param("homeworkId") Integer homeworkId);
}
