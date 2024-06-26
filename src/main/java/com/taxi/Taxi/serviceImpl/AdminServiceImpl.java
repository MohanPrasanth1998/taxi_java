package com.taxi.Taxi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.Taxi.dao.AdminDao;
import com.taxi.Taxi.dto.AdminDto;
import com.taxi.Taxi.model.Admin;
import com.taxi.Taxi.service.AdminService;
import com.taxi.Taxi.util.ExceptionMessageUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin saveAdmin(AdminDto adminDto) {

		log.debug("Save Admin Details");
		try {
			Admin admDetails = modelMapper.map(adminDto, Admin.class);
			return adminDao.save(admDetails);
		} catch (Exception e) {
			log.error(e.getMessage());
			;
			throw new RuntimeException(ExceptionMessageUtil.ADMIN_DETAILS_FAILED_TO_SAVE);
		}
	}

	@Override
	public Admin updateAdmin(AdminDto adminDto) throws Exception {
		log.info("Update Admin Details");
		try {
			Admin admin = adminDao.findByadminId(adminDto.getAdminId());
			if (admin != null) {
				admin.setAdminId(adminDto.getAdminId());
				admin.setUserName(adminDto.getUserName());
				admin.setPassword(adminDto.getPassword());
				return adminDao.save(admin);
			}
			throw new Exception(ExceptionMessageUtil.ADMIN_ID_FAILED_TO_GET);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(ExceptionMessageUtil.ADMIN_UPDATE_FAILED);
		}

	}

	@Override
	public Admin getAdminById(Integer adminId) throws Exception {
		log.info("Get Admin Deatils");
		try {
			return adminDao.findByadminId(adminId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(ExceptionMessageUtil.ADMIN_NOT_FOUND_BY_ID);
		}
	}
	
	@Override
	public boolean deleteAdmin(Integer adminId) {
		try {
			adminDao.deleteByadminId(adminId);
			return true;
			
		} catch (Exception e) {
		    log.error(e.getLocalizedMessage());
		    return false;
		}
		
	}


}
