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
import com.sprint1.spc.exception.ParentServiceException;
import com.sprint1.spc.repository.IFeeRepository;
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
		return iParentRepository.saveAndFlush(parent);
	}

	/***** Retrieve Parent *****/
	@Override
	public List<Parent> retrieveAllParents() {
		return iParentRepository.findAll();
	}

	/***** Patch Student To Parent *****/
	@Override
	public Parent updateStudentToParent(long id, Parent parent) throws ParentServiceException {
		Parent existingParent = iParentRepository.findById(id).orElseThrow(ParentServiceException::new);
		existingParent.setStudents(parent.getStudents());
		iParentRepository.save(existingParent);
		return existingParent;
	}
	
	/***** Update Parent *****/
	@Override
	public Parent updateParent(long id, long phoneNumber) throws ParentServiceException {
		Parent existingParent = iParentRepository.findById(id).orElseThrow(ParentServiceException::new);
		existingParent.setPhoneNumber(phoneNumber);
		iParentRepository.save(existingParent);
		return existingParent;
	}

	/***** Retrieve Parent By Id *****/
	@Override
	public Parent retrieveParentById(long id) {
		Parent parent = iParentRepository.getById(id);
		return parent;
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
		return parentId;
	}

	/***** Add Concern *****/
	@Override
	public Concern addConcern1(Concern concern) {
		return concernServiceImpl.addConcern(concern);
	}

	/***** Retrieve Concerns *****/
	@Override
	public List<Concern> retrieveAllConcerns1() {
		List<Concern> concernList = concernServiceImpl.retrieveAllConcerns();
		return concernList;
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
		return fee;
	}
}