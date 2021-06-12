package com.sprint1.spc.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.exception.ParentServiceException;

@Service
public interface IParentService {
	public long retrieveAccountantById(long id);
	public Parent addParent(Parent parent);
	public List<Parent> retrieveAllParents();
	public Parent updateParent(long id, Parent parent) throws ParentServiceException;
	//public Parent retrieveParentByStudentId(long id);
	public Parent retrieveParentById(long id);
	public Concern addConcern1(Concern concern);
	public List<Concern> retrieveAllConcerns1();
	public Fee getFee();
}