package com.sprint1.spc.services;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.sprint1.spc.entities.User;
import com.sprint1.spc.exception.StudentIDNotFoundException;
import com.sprint1.spc.exception.UserNotFoundException;
import com.sprint1.spc.repository.IParentRepository;
import com.sprint1.spc.repository.IStudentRepository;

@Service
public class ParentServiceImpl implements IParentService {
	
	/***** Parent Service Implementation *****/

	@Autowired
	private IParentRepository iParentRepository;
	
	@Autowired
	private ConcernServiceImpl concernServiceImpl;
	
	@Autowired
	private IStudentRepository iStudentRepository;
	
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

	/***** Patch Student To Parent  *****/
//	@Override
//	public Parent updateStudentToParent(long id, Parent parent) throws StudentIDNotFoundException {
//		Parent existingParent = iParentRepository.getById(id);
//		Set<Student> studentList = new HashSet<Student>();
//		Student s1 = null;
//		if(!existingParent.equals(null)) {
//			for(Student s: parent.getStudents()) {
//				s1 = iStudentRepository.findById(s.getId()).orElseThrow(StudentIDNotFoundException:: new);
//				studentList.add(s1);
//			}
//			existingParent.setStudents(studentList);
//			iParentRepository.save(existingParent);
//			return existingParent;
//		}
//		else {
//			return null;
//		}
//	}
	
	public Parent updateStudentToParent(long studentId, Parent parent) {
		Parent existingParent = iParentRepository.findById(parent.getId()).get();
		List<Student> studentList = iStudentRepository.findAll();
//		Student student = iStudentRepository.findById(studentId).get();
		Set<Student> studentSet = new HashSet<Student>();
		for(Student student: studentList) {
			if(student.getId() == studentId) {
				studentSet.add(student);
			}
		}
		existingParent.setStudents(studentSet);
		iParentRepository.save(existingParent);
		return existingParent;
	}

	/***** Update Parent *****/
	
	@Override
	public Parent updateParent(Parent parent) throws UserNotFoundException {
		long parentId = parent.getId();
		String id = Long.toString(parentId);
		Parent parentDb = iParentRepository.findById(parentId).get();
		if((id.equals(null)) || (parentDb.equals(null))) {
			throw new UserNotFoundException("Can't Update Student, Please Try Again!");
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
//	@Override
//	public Concern addConcern(long parentId,Concern concern) {
//		if(!concern.equals(null)) {
//			return concernServiceImpl.addConcern(parentId,concern);
//		}
//		else {
//			return null;
//		}
//	}
	
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
	
	@Override
	public Parent getParentByEmailId(String email) {
		Parent user = iParentRepository.findByEmailId(email);
		return user;
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