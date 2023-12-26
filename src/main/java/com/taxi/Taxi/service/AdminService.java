package com.taxi.Taxi.service;

import com.taxi.Taxi.dto.AdminDto;
import com.taxi.Taxi.model.Admin;

public interface AdminService {
	
	Admin saveAdmin(AdminDto adminDto);


	


	Admin getAdminById(Integer adminId) throws Exception;


	boolean deleteAdmin(Integer adminId);


	Admin updateAdmin(AdminDto adminDto) throws Exception;


}
