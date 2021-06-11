package com.sprint1.spc.services;

import java.util.*;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Accountant;


@Service
public interface IAccountantService {
	public List<Accountant> retrieveAllAccountants();
	public long retrieveAccountantById(long id);
	public Accountant addAccountant(Accountant accountant);
	public Accountant updateAccountant(Accountant accountant);

	public Accountant patchAccountant(long phoneNumber, long accountantId);
	
}