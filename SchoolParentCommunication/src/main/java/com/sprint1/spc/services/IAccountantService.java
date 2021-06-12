package com.sprint1.spc.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.entities.Fee;
import com.sprint1.spc.entities.Student;

@Service
public interface IAccountantService {
	public List<Accountant> retrieveAllAccountants();
	public long retrieveAccountantById(long id);
	public Accountant addAccountant(Accountant accountant);
	public Accountant updateAccountant(Accountant accountant);
	public Accountant patchAccountant(long phoneNumber, long accountantId);
	public void deleteAccountant(long accountantId);
	public Student updateFeeToStudent(long id, Fee fee);
}