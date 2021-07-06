package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint1.spc.entities.Teacher;

public interface ITeacherRepository  extends JpaRepository<Teacher, Long> {
	@Query("select t from Teacher t where t.emailId = ?1")
    public Teacher findByEmailId(String email);
	
}