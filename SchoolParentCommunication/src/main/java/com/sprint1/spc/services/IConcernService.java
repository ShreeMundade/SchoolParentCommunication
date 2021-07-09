package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.exception.ConcernNotFoundException;

@Service
@Transactional
public interface IConcernService {
	public Concern updateConcern(Concern concern) throws ConcernNotFoundException;
	public List<Concern> retrieveAllConcerns();
	List<Concern> retrieveAllConcernsByParentId(long id);
//	Concern addConcern(String concernDesc, LocalDate concernDate, long parentId, ConcernType type);
//	public List<Concern> retrieveAllConcernsByParent(Parent parent);
//	public Concern addConcern(Concern concern);
//	public List<Concern> retrieveAllUnResolvedConcerns();
//	public List<Concern> retrieveAllUnResolvedConcernsByParent(Parent parent);
	public Concern addConcern(Concern concern);
	public Concern retrieveConcernById(long id);	
}