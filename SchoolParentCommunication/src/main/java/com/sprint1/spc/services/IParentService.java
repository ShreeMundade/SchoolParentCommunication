package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.ParentServiceException;
import com.sprint1.spc.exception.StudentIDNotFoundException;
import com.sprint1.spc.exception.UserNotFoundException;

@Service
@Transactional
public interface IParentService {
	public Parent addParent(Parent parent);
	public List<Parent> retrieveAllParents();
	public Parent retrieveParentById(long id);
//	public Concern addConcern1(Concern concern);
	public List<Concern> retrieveAllConcerns1();
	public Fee getFeeByParentId(long parentId);
	public long retrieveParentById1(long id);
	//public Parent retrieveParentByStudentId(long id);
	public Parent updateStudentToParent(long studentId, Parent parent);
	public Parent updateParent(Parent parent) throws ParentServiceException, UserNotFoundException;
//	Concern addConcern(String concernDesc, LocalDate concernDate, long parentId, ConcernType type);
//	public Concern addConcern(Concern concern);
	public User getParentByEmailId(String email);
}