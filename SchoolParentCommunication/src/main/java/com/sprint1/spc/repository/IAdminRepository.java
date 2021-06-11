package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long> {	
}