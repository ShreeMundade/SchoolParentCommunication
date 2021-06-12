package com.sprint1.spc.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.spc.entities.Role;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	public User findByEmailIdAndPassword(String emailId,String password);
	public User findByEmailId(String emailId);
	public Student getById(Student student);
	public List<User> findByRole(Role role);
}