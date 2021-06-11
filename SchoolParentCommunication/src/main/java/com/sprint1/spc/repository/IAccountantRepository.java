package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Accountant;

public interface IAccountantRepository extends JpaRepository<Accountant, Long> {
	
}