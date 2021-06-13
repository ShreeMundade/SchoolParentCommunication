package com.sprint1.spc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.ConcernNotFoundException;
import com.sprint1.spc.repository.IConcernRepository;
import com.sprint1.spc.repository.IParentRepository;

@Service
public class ConcernServiceImpl implements IConcernService {
	@Autowired
	private IConcernRepository iConcernRepo;
	
	@Autowired
	private IParentRepository iParentRepo;

	@Override
	public Concern addConcern(Concern concern) {
		return iConcernRepo.saveAndFlush(concern);
	}

	@Override
	public Concern updateConcern(Concern concern) throws ConcernNotFoundException {
		Concern existingConcern = iConcernRepo.getById(concern.getConcernId());
		BeanUtils.copyProperties(concern, existingConcern, "concernId");
		return existingConcern;

	}


	@Override
	public List<Concern> retrieveAllConcerns() {

		return iConcernRepo.findAll();
	}


	@Override
	public List<Concern> retrieveAllConcernsByParentId(long id) {
		Parent parent=iParentRepo.findById(id).get();
		List<Concern> concernList = iConcernRepo.findAll();
		List<Concern> filteredConcern=new ArrayList<Concern>();
		for(Concern concern:concernList) {
			if(parent.getId()==concern.getAffectedParty().getId()) {
				filteredConcern.add(concern);
			}
		}
		return filteredConcern;
	}
	

//	@Override
//	public List<Concern> retrieveAllUnResolvedConcerns() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Concern> retrieveAllUnResolvedConcernsByParent(Parent parent) {
//		// TODO Auto-generated method stub
//		return null;
//	}



	

}
