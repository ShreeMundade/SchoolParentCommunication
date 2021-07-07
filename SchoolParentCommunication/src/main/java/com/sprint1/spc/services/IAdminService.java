package com.sprint1.spc.services;

import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Admin;

@Service
public interface IAdminService {

	public Admin addAdmin(Admin admin);
	public Admin getAdminByEmailId(String email);
	//public boolean retrieveAdminById(long id);
}