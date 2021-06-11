package com.sprint1.spc.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Parent;

@Service
public interface IParentService {
	public long retrieveAccountantById(long id);
	public Parent addParent(Parent parent);
	public List<Parent> retrieveAllParents();
	public Parent updateParent(long id, Parent parent);
	//public Parent retrieveParentByStudentId(long id);
	public Parent retrieveParentById(long id);
	public Concern addConcern1(Concern concern);
	public List<Concern> retrieveAllConcerns1();
}