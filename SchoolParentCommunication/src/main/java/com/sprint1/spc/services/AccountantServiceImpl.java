package com.sprint1.spc.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Accountant;
import com.sprint1.spc.repository.IAccountantRepository;

@Service
public class AccountantServiceImpl implements IAccountantService {

	@Autowired
	private IAccountantRepository iAccountantRepository;

	@Override
	public List<Accountant> retrieveAllAccountants() {
		return iAccountantRepository.findAll();
	}

	@Override
	public long retrieveAccountantById(long id) {
		List<Accountant> accountantList = iAccountantRepository.findAll();
		long accountantId = 0;
		for (Accountant accountant : accountantList) {
			if (accountant.getId() == id) {
				accountantId = id;
			}
		}
		return accountantId;
	}

	@Override
	public Accountant addAccountant(Accountant accountant) {
		return iAccountantRepository.save(accountant);
	}

	@Override
	public Accountant updateAccountant(Accountant accountant) {
		return iAccountantRepository.saveAndFlush(accountant);
	}

	@Override
	public Accountant patchAccountant(long phoneNumber, long accountantId) {
		Accountant accountant = iAccountantRepository.findById(accountantId).get();
		accountant.setPhoneNumber(phoneNumber);
		iAccountantRepository.save(accountant);
		return accountant;
	}

	@Override
	public void deleteAccountant(long accountantId) {
		iAccountantRepository.deleteById(accountantId);
	}
}