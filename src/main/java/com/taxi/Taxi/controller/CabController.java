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

import com.taxi.Taxi.dto.CabDto;
import com.taxi.Taxi.model.Cab;
import com.taxi.Taxi.service.CabService;
import com.taxi.Taxi.util.ExceptionMessageUtil;
import com.taxi.Taxi.util.Response;
import com.taxi.Taxi.util.ResponseMessageUtil;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/vehicle")
@RestController
@Slf4j
public class CabController {

	@Autowired
	private CabService cabService;

	@PostMapping("/save")
	public Response saveOrUpdate(@RequestBody CabDto cabDto) {
		log.info("Save Cab Details");
		Cab details = cabService.saveOrUpdate(cabDto);
		if (details != null)
			return new Response(new Date(),ResponseMessageUtil.SUCCESS , HttpStatus.OK);
		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/update")
	public Response update(@Valid @RequestBody CabDto cabDto) throws Exception {
		log.info("Update Cab Details");

		Cab cab = cabService.updateCab(cabDto);

		if (cab != null)
			return new Response(new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.OK);
		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/get/{cabId}")
	public Cab getcabById(@PathVariable("cabId") Integer cabId) {
		log.debug("Cab Details");
		try {
			return cabService.getCabById(cabId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(ExceptionMessageUtil.CAB_DETAILS_FAILED_TO_GET_ON_CONTROLLER);
		}

	}

	@DeleteMapping("/delete/{cabId}")
	public Response deleteCab(Integer cabId) {
		log.info("Delete Cab Details");
		boolean isdelete = cabService.deleteCab(cabId);
		if (isdelete)
			return new Response(new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.OK);

		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);

	}

}
