package com.sprint1.spc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Parent;

@Service
public interface IConcernService {
	public Concern addConcern(Concern concern);
	public Concern updateConcern(Concern concern);
	public List<Concern> retrieveAllConcerns();
	public List<Concern> retrieveAllConcernsByParent(Parent parent);
	public List<Concern> retrieveAllUnResolvedConcerns();
	public List<Concern> retrieveAllUnResolvedConcernsByParent(Parent parent);
	
	
	
}
