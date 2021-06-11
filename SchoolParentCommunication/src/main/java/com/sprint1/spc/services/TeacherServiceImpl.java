package com.sprint1.spc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService{
	
	@Autowired
	private ITeacherRepository TeacherRepo;

	@Override
	public Teacher addTeacher(Teacher Teacher) {
		
		return TeacherRepo.saveAndFlush(Teacher);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Teacher teacher1=TeacherRepo.findById(teacher.getId());

		return teacher1;	
	}
	

	@Override
	public List<Teacher> retrieveAllTeachers() {
		
		return TeacherRepo.findAll();
	}

	
	@Override
	public Teacher retrieveTeacherById(long id) {
		
		return TeacherRepo.findById(id);
	}






	
	
	

}
