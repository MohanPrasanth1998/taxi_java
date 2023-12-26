package com.taxi.Taxi.controller;

import java.util.Date;
import java.util.List;

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

import com.taxi.Taxi.dto.HolidayPackageDto;
import com.taxi.Taxi.model.HolidayPackage;
import com.taxi.Taxi.service.HolidayPackageService;
import com.taxi.Taxi.util.Response;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/holiday")
public class HolidayPackagesController {

	@Autowired
	private HolidayPackageService holidayPackageService;

	@PostMapping("/save")
	public Response saveHoliday(@Valid @RequestBody HolidayPackageDto holidayPackageDto) {
		log.info("Save Holiday Packages");
		HolidayPackage holidayPackage = holidayPackageService.save(holidayPackageDto);
		if (holidayPackage != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/update/holiday")
	public Response UpdateHoliday(@Valid @RequestBody HolidayPackageDto holidayPackageDto) throws Exception {

		log.info("Update Holiday Packages");
		HolidayPackage holidayPackage = holidayPackageService.update(holidayPackageDto);
		if (holidayPackage != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/get/{packageId}")
	public List<HolidayPackageDto> getPackageById(@Valid @PathVariable("packageId") Long packageId) {
		log.debug("Get Package By PackageID");
		try {
			return holidayPackageService.getPackageById(packageId);

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new RuntimeException("Failed to get Packages");
		}

	}

	@DeleteMapping("/delete/{packageId}")
	public Response deletePackage(Long packageId) {
		log.info("Delete package Details");
		boolean isdelete = holidayPackageService.deletePackage(packageId);
		if (isdelete)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

}
