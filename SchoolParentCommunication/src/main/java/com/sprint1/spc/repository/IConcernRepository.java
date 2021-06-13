package com.sprint1.spc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprint1.spc.entities.Concern;
import com.sprint1.spc.entities.Parent;

public interface IConcernRepository extends JpaRepository<Concern, Long> {

}