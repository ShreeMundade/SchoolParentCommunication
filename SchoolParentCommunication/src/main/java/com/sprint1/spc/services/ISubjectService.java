package com.sprint1.spc.services;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Subject;

@Service
public interface ISubjectService {
	public Subject addSubject(Subject subject);
}
