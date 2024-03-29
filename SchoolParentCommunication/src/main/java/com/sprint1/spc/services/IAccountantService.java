package com.sprint1.spc.services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Student;
import com.sprint1.spc.exception.UserNotFoundException;

@Service
@Transactional
public interface IAccountantService {
	public List<Accountant> retrieveAllAccountants();

	public long retrieveAccountantById(long id);

	public Accountant retrieveAccountantById1(long id);

	public Accountant addAccountant(Accountant accountant);

	public Accountant patchAccountant(String phoneNumber, long accountantId);

	public void deleteAccountant(long accountantId);

	public Student updateFeeToStudent(long id, Fee fee);

	public Accountant getAccountantByEmailId(String email);

	public Accountant updateAccountant(Accountant accountant) throws UserNotFoundException;
}