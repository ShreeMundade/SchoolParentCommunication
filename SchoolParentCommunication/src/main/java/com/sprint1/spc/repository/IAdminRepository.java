package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint1.spc.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long> {	
	@Query("select a from Admin a where a.emailId = ?1")
    public Admin findByEmailId(String email);
}