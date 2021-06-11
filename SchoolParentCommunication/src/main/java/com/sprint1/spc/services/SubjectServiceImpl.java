package com.sprint1.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Subject;
import com.sprint1.spc.repository.ISubjectRepository;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	private ISubjectRepository iSubjectRepository;

	@Override
	public Subject addSubject(Subject subject) {
		return iSubjectRepository.save(subject);
	}

	public List<Subject> retrieveAllSubjects() {
		return iSubjectRepository.findAll();
	}
}