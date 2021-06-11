package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Subject;

public interface ISubjectRepository extends JpaRepository<Subject, Long> {
}