package com.sprint1.spc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.StudentClass;

@Service
@Transactional
public interface IStudentClassService {
	public StudentClass addStudentClass(StudentClass studentClass);

	public StudentClass deleteStudentClassById(long studentClassId);
}