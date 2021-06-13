package com.sprint1.spc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.ConcernNotFoundException;
import com.sprint1.spc.repository.IConcernRepository;

@Service
public class ConcernServiceImpl implements IConcernService{
	@Autowired
	private IConcernRepository iConcernRepo;
	@Override
	public Concern addConcern(Concern concern) {
		return iConcernRepo.saveAndFlush(concern);
		
		
	}


	@Override
	public List<Concern> retrieveAllConcerns() {
		// TODO Auto-generated method stub
		return iConcernRepo.findAll();
	}

	@Override
	public List<Concern> retrieveAllConcernsByParent(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Concern> retrieveAllUnResolvedConcerns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Concern> retrieveAllUnResolvedConcernsByParent(Parent parent) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Concern updateConcern(Concern concern) throws ConcernNotFoundException{
		Concern existingConcern = iConcernRepo.getById(concern.getConcernId());
		BeanUtils.copyProperties(concern, existingConcern, "concernId");
		return existingConcern;
		
	}


	
	
}
