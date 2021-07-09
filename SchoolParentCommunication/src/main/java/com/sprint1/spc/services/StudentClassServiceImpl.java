package com.sprint1.spc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.StudentClass;
import com.sprint1.spc.repository.IStudentClassRepository;

@Service
@Transactional
public class StudentClassServiceImpl implements IStudentClassService {
	
	@Autowired
	private IStudentClassRepository iStudentClassRepository;

	@Override
	public StudentClass addStudentClass(StudentClass studentClass) {
		return iStudentClassRepository.save(studentClass);
	}
	
	
	@Override
	public StudentClass deleteStudentClassById(long studentClassId) {
		StudentClass s=iStudentClassRepository.findById(studentClassId).get();
		iStudentClassRepository.deleteById(studentClassId);
		return s;
		
	}
	
}