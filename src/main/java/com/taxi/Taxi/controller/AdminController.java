package com.taxi.Taxi.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taxi.Taxi.dto.AdminDto;
import com.taxi.Taxi.model.Admin;
import com.taxi.Taxi.service.AdminService;
import com.taxi.Taxi.util.Response;
import com.taxi.Taxi.util.ResponseMessageUtil;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/save")
	public Response save(@Valid @RequestBody AdminDto adminDto) {
		Admin admin = adminService.saveAdmin(adminDto);
		if (admin != null)
			return new Response(new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.OK);
		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/update")
	public Response update(@Valid @RequestBody AdminDto adminDto) throws Exception {

		Admin admin = adminService.updateAdmin(adminDto);

		if (admin != null)
			return new Response(new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.OK);
		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/get/{adminId}")
	public Admin getAdmin(@PathVariable("adminId") Integer adminId) throws Exception {
		log.info("Get Admin Details ");
		return adminService.getAdminById(adminId);

	}

	@DeleteMapping("/delete/{adminId}")
	public Response deleteDetails(@PathVariable("adminId") Integer adminId) throws Exception {
		log.info("Delete Admin Details By Id");
		boolean isdelete = adminService.deleteAdmin(adminId);
		if (isdelete)
			return new Response(new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.OK);
		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);

	}

}
