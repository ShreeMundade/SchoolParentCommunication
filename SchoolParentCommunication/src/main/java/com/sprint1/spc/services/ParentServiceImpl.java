package com.sprint1.spc.services;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.entities.Student;
<<<<<<< Updated upstream
import com.sprint1.spc.exception.ParentServiceException;
=======
import com.sprint1.spc.exception.UserNotFoundException;
>>>>>>> Stashed changes
import com.sprint1.spc.repository.IParentRepository;

@Service
public class ParentServiceImpl implements IParentService {
	
	/***** Parent Service Implementation *****/

	@Autowired
	private IParentRepository iParentRepository;
	
	@Autowired
	private ConcernServiceImpl concernServiceImpl;
	
	@PersistenceContext
	private EntityManager entityManager;

	/***** Add Parent *****/
	@Override
	public Parent addParent(Parent parent) {
		if(!parent.equals(null)) {
			return iParentRepository.save(parent);
		}
		else {
			return null;
		}
	}

	/***** Retrieve Parent *****/
	@Override
	public List<Parent> retrieveAllParents() {
		List<Parent> parentList = iParentRepository.findAll();
		if(!parentList.equals(null)) {
			return parentList;
		}
		else {
			return null;
		} 
	}

	/***** Patch Student To Parent *****/
	@Override
	public Parent updateStudentToParent(long id, Parent parent) {
		Parent existingParent = iParentRepository.getById(id);
		if(!existingParent.equals(null)) {
			existingParent.setStudents(parent.getStudents());
			iParentRepository.save(existingParent);
			return existingParent;
		}
		else {
			return null;
		}
	}

	/***** Update Parent *****/
	
	@Override
<<<<<<< Updated upstream
	public Parent updateParent(long id, String phoneNumber) {
		Parent existingParent = iParentRepository.getById(id);
		if(!existingParent.equals(null)) {
			existingParent.setPhoneNumber(phoneNumber);
			iParentRepository.save(existingParent);
			return existingParent;
=======
	public Parent updateParent(Parent parent) throws UserNotFoundException {
		long parentId = parent.getId();
		String id = Long.toString(parentId);
		Parent parentDb = iParentRepository.findById(parentId).get();
		if((id.equals(null)) || (parentDb.equals(null))) {
			throw new UserNotFoundException("Can't Update Student, Please Try Again!");
>>>>>>> Stashed changes
		}
		else {
			BeanUtils.copyProperties(parent, parentDb, "parentId");
			iParentRepository.save(parentDb);
			return parentDb;
		}
	}
	

	/***** Retrieve Parent By Id *****/
	@Override
	public Parent retrieveParentById(long id) {
		Parent parent = iParentRepository.findById(id).get();
		if(!parent.equals(null)) {
			return parent;
		}
		else {
			return null;
		}
	}

	/***** Retrieve Parent Id By Id *****/
	@Override
	public long retrieveParentById1(long id) {
		List<Parent> parentList = iParentRepository.findAll();
		long parentId = 0;
		for(Parent parent: parentList) {
			if(parent.getId() == id) {
				parentId = id;
			}
		}
		if(parentId != 0) {
			return parentId;
		}
		else {
			return 0;
		}
	}

	/***** Add Concern *****/
	@Override
	public Concern addConcern(Concern concern) {
		if(!concern.equals(null)) {
			return concernServiceImpl.addConcern(concern);
		}
		else {
			return null;
		}
	}
	
	/***** Retrieve Concerns *****/
	@Override
	public List<Concern> retrieveAllConcerns1() {
		List<Concern> concernList = concernServiceImpl.retrieveAllConcerns();
		if(!concernList.equals(null)) {
			return concernList;
		}
		else {
			return null;
		}
	}

	/***** Retrieve Fee By Parent Id *****/
	@Override
	public Fee getFeeByParentId(long parentId) {
		Parent parent = iParentRepository.findById(parentId).get();
		Set<Student> studentSet = parent.getStudents();
		Fee fee = new Fee();
		for(Student student : studentSet) {
			fee = student.getFee();
		}
		if(!fee.equals(null)) {
			return fee;
		}
		else {
			return null;
		}
	}

	

	
//	/***** Add Concern *****/
//	@Override
//	public Concern addConcern(String concernDesc, LocalDate concernDate, long parentId, ConcernType type) {
//		Concern concern = new Concern();
//		Parent parent = iParentRepository.getById(parentId);
//		concern.setConcernId(0);
//		concern.setConcernDescription(concernDesc);
//		concern.setResolved(false);
//		concern.setResolution(null);
//		concern.setConcernDate(concernDate);
//		concern.setResolvedDate(null);
//		concern.setParty(null);
//		concern.setAffectedParty(parent);
//		concern.setResolvedBy(null);
//		concern.setType(type);
//		if(!concern.equals(null)) {
//			
//			return iConcernRepository.save(concern);
//		}
//		else {
//			return null;
//		}
//	}
}