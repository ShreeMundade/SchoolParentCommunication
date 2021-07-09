package com.sprint1.spc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.spc.entities.Admin;

@Service
@Transactional
public interface IAdminService {

	public Admin addAdmin(Admin admin);
	public Admin getAdminByEmailId(String email);
	//public boolean retrieveAdminById(long id);
}