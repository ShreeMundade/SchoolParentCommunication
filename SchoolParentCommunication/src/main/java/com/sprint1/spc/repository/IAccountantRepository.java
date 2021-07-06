package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint1.spc.entities.Accountant;

public interface IAccountantRepository extends JpaRepository<Accountant, Long> {
	@Query("select a from Accountant a where a.emailId = ?1")
    public Accountant findByEmailId(String email);
}