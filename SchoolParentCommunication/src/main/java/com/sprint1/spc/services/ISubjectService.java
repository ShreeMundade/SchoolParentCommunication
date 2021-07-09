package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Subject;

@Service
@Transactional
public interface ISubjectService {
	public Subject addSubject(Subject subject);
	public List<Subject> retrieveAllSubjects(); 
	public Subject getSubjectById(long subjectId);
}
