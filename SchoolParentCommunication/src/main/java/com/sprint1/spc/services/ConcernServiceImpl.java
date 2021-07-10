package com.sprint1.spc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Teacher;
import com.sprint1.spc.exception.ConcernNotFoundException;
import com.sprint1.spc.repository.IConcernRepository;
import com.sprint1.spc.repository.IParentRepository;
import com.sprint1.spc.repository.ITeacherRepository;

@Service
@Transactional
public class ConcernServiceImpl implements IConcernService {
	@Autowired
	private IConcernRepository iConcernRepo;

	@Autowired
	private IParentRepository iParentRepo;
	
	@Autowired
	private ITeacherRepository teacherRepo;

	@Override
	public Concern addConcern(Concern concern) {
		return iConcernRepo.save(concern);
	}

	@Override
	public Concern updateConcern(long teacherId,Concern concern) throws ConcernNotFoundException {
		Concern existingConcern = iConcernRepo.getById(concern.getConcernId());
		Teacher teacher = teacherRepo.findById(teacherId).get();
		existingConcern.setResolution(concern.getResolution());
		existingConcern.setResolved(concern.isResolved());
		existingConcern.setResolvedBy(teacher);
		existingConcern.setResolvedDate(LocalDate.now());
		iConcernRepo.save(existingConcern);
//		BeanUtils.copyProperties(concern, existingConcern, "concernId");
		return existingConcern;
	}
//resolution resolved by id 
	@Override
	public List<Concern> retrieveAllConcerns() {
		return iConcernRepo.findAll();
	}

	@Override
	public List<Concern> retrieveAllConcernsByParentId(long id) {
		Parent parent = iParentRepo.findById(id).get();
		List<Concern> concernList = iConcernRepo.findAll();
		List<Concern> filteredConcern = new ArrayList<Concern>();
		for (Concern concern : concernList) {
			if (parent.getId() == concern.getAffectedParty().getId()) {
				filteredConcern.add(concern);
			}
		}
		return filteredConcern;
	}

	@Override
	public Concern retrieveConcernById(long id) {
		Concern concern = iConcernRepo.findById(id).get();
		return concern;
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