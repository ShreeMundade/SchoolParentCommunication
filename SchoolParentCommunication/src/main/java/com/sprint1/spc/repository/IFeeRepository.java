package com.sprint1.spc.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint1.spc.entities.Fee;

public interface IFeeRepository extends JpaRepository<Fee, Long> {
	@Query(value = "select s.fee from Student s where s.id = ?1")
	public List<Fee> retrieveFeeByStudentId(long id);
	@Query(value = "select s.fee from Student s where s.name = ?1")
	public Fee retrieveFeesByStudentName(String name);
}