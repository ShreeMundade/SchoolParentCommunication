package com.sprint1.spc.services;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.StudentClass;

@Service
public interface IStudentClassService {
	public StudentClass addStudentClass(StudentClass studentClass);
}