package com.sprint1.spc.services;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.TeacherNotFoundException;
import com.sprint1.spc.repository.IConcernRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService {
	
	/***** Teacher Service Implementation *****/
	
	@Autowired
	private ITeacherRepository iTeacherRepo;
	
	@Autowired
	private IConcernRepository iConcernRepo;
	
	@Autowired
	private ConcernServiceImpl concernServiceImpl;

	/***** Add Teacher *****/
	@Override
	public Teacher addTeacher(Teacher teacher) {
		return iTeacherRepo.saveAndFlush(teacher);
	}

	/***** Update Teacher *****/
	@Override
	public Teacher updateTeacher(Teacher teacher) throws TeacherNotFoundException {
		Teacher existingTeacher = iTeacherRepo.getById(teacher.getId());
		BeanUtils.copyProperties(teacher, existingTeacher, "teacherId");
		return existingTeacher;
	}

	/***** Retrieve All Teachers *****/
	@Override
	public List<Teacher> retrieveAllTeachers() {
		return iTeacherRepo.findAll();
	}

	/***** Retrieve All Concerns *****/
	@Override
	public List<Concern> retrieveAllConcerns() {
		return iConcernRepo.findAll();
	}

	/***** Patch Concern *****/
//	@Override
//	public Concern patchConcern(long teacherId, long concernId, String resolution) {
//		Concern concern = concernServiceImpl.findById(concernId);
//		return concern;
//	}

	/***** Find Teacher By Id *****/
	@Override
	public Teacher retrieveTeacherById(long id) {
		return iTeacherRepo.getById(id);
	}
}