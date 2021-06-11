package com.sprint1.spc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Parent;
import com.sprint1.spc.repository.IParentRepository;

@Service
public class ParentServiceImpl implements IParentService {

	@Autowired
	private IParentRepository iParentRepository;

	@Autowired
	private ConcernServiceImpl concernServiceImpl;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Parent addParent(Parent parent) {
		return iParentRepository.saveAndFlush(parent);
	}

	@Override
	public List<Parent> retrieveAllParents() {
		return iParentRepository.findAll();
	}
	
	@Override
	public Parent updateParent(long id, Parent parent) {
		Parent existingParent = iParentRepository.getById(id);
		BeanUtils.copyProperties(parent, existingParent, "parentId");
		return existingParent;
	}

	@Override
	public Parent retrieveParentById(long id) {
		Parent parent = iParentRepository.getById(id);
		return parent;
	}

//	@Override
//	public List<Parent> retrieveParentByStudentId(long id) {
//		List<Parent> parentList = iParentRepository.findAll();
//		List<Parent> parentObj = new ArrayList<Parent>();
//		List<Student> studentList = new ArrayList<Student>();
//		Set<Student> studentSet = new HashSet<Student>();
//		for(Parent parent: parentList)
//		{
//			studentSet.addAll(parent.getStudents());
//		}
//		for(Student student: studentSet)
//		{
//			studentList.add(student);
//		}
//		for(Student student: studentList)
//		{
//			if(student.getId() == id)
//			{
//				parentObj.addAll(parentList);
//			}
//		}
//		Parent parent = (Parent)entityManager.createQuery("select p from Parent p, Student s where p.id = s.id and s.id = ?1").setParameter(1, id).getSingleResult();
//		return parentObj;
//	}
	
//	@Override
//	public Parent retrieveParentByStudentId(long id) {
//		Parent parent = iParentRepository.retrieveParentByStudentId(id);
//		return parent;
//	}
//	
	@Override
	public long retrieveAccountantById(long id) {
		List<Parent> parentList = iParentRepository.findAll();
		long parentId = 0;
		for(Parent parent: parentList) {
			if(parent.getId() == id) {
				parentId = id;
			}
		}
		return parentId;
	}

	@Override
	public Concern addConcern1(Concern concern) {
		return concernServiceImpl.addConcern(concern);
	}

	@Override
	public List<Concern> retrieveAllConcerns1() {
		List<Concern> concernList = concernServiceImpl.retrieveAllConcerns();
		return concernList;
	}

	
	
}