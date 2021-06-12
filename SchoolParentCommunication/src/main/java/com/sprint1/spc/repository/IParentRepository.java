package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Parent;

public interface IParentRepository extends JpaRepository<Parent, Long> {

//	@Query(value = "select p from Parent p join Student s where  s.id = id")
//	public Parent retrieveParentByStudentId(long id);
}