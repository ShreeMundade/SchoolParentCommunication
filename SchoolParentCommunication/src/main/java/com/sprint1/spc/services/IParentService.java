package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.exception.ParentServiceException;
import com.sprint1.spc.exception.UserNotFoundException;

@Service
public interface IParentService {
	public Parent addParent(Parent parent);
	public List<Parent> retrieveAllParents();
	public Parent retrieveParentById(long id);
//	public Concern addConcern1(Concern concern);
	public List<Concern> retrieveAllConcerns1();
	public Fee getFeeByParentId(long parentId);
	public long retrieveParentById1(long id);
	//public Parent retrieveParentByStudentId(long id);
	public Parent updateStudentToParent(long id, Parent parent) throws ParentServiceException;
	public Parent updateParent(Parent parent) throws ParentServiceException, UserNotFoundException;
//	Concern addConcern(String concernDesc, LocalDate concernDate, long parentId, ConcernType type);
	public Concern addConcern(Concern concern);
}