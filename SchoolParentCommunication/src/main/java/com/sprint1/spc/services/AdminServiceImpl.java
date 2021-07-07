package com.sprint1.spc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.spc.entities.Admin;
import com.sprint1.spc.repository.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository iAdminRepository;

	

	@Override
	public Admin addAdmin(Admin admin) {
		return iAdminRepository.save(admin);
	}



	@Override
	public Admin getAdminByEmailId(String email) {
		List<Admin> adminList = iAdminRepository.findAll();
		for(Admin admin: adminList) {
			if(admin.getEmailId() == email) {
				return admin;
			}
		}
		return null;
	}
}