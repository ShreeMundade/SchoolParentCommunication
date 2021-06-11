package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sprint1.spc.entities.Teacher;

public interface ITeacherRepository  extends JpaRepository<Teacher, Long> {
	public Teacher findById(long id);
	
}