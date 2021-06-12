package com.sprint1.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.repository.IStudentClassRepository;

@Service
public class StudentClassServiceImpl implements IStudentClassService {
	
	@Autowired
	private IStudentClassRepository iStudentClassRepository;

	public StudentClass addStudentClass(StudentClass studentClass) {
		return iStudentClassRepository.save(studentClass);
	}

	public void deleteStudentClassById(long studentClassId) {
		iStudentClassRepository.deleteById(studentClassId);
	}
}