package com.sprint1.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.StudentClass;

public interface IStudentClassRepository extends JpaRepository<StudentClass, Long> {
}