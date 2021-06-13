package com.sprint1.spc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Concern;

public interface IConcernRepository extends JpaRepository<Concern, Long> {

	Object updateConcern(Concern concern);

	
	
}