package com.sprint1.spc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.repository.IConcernRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService{
	
	@Autowired
	private ITeacherRepository iTeacherRepo;
	
	@Autowired
	private IConcernRepository iConcernRepo;
	
	@Autowired
	private ConcernServiceImpl concernServiceImpl;

	@Override
	public Teacher addTeacher(Teacher Teacher) {
		
		return iTeacherRepo.saveAndFlush(Teacher);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Teacher teacher1=iTeacherRepo.findById(teacher.getId());

		return teacher1;	
	}
	

	@Override
	public List<Teacher> retrieveAllTeachers() {
		
		return iTeacherRepo.findAll();
	}

	
	@Override
	public Teacher retrieveTeacherById(long id) {
		
		return iTeacherRepo.findById(id);
	}

	
	@Override
	public List<Concern> retrieveAllConcerns() {
		return concernServiceImpl.retrieveAllConcerns();
	}

	public Concern patchConcern(long teacherId, long concernId,String resolution) {
		Concern concern=iConcernRepo.findById(concernId).get();
		return concern;
	}




	
	
	

}
