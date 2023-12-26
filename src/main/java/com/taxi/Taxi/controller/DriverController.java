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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.Taxi.dto.DriverDto;
import com.taxi.Taxi.model.Driver;
import com.taxi.Taxi.service.DriverService;

import com.taxi.Taxi.util.Response;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/driver")
@RestController
@Slf4j
public class DriverController {

	@Autowired
	private DriverService driverService;

	@PostMapping("/save")
	public Response saveOrUpdate(@RequestBody DriverDto driverDto) {
		Driver driver = driverService.saveOrUpdate(driverDto);
		if (driver != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/update")
	public Response updateDriver(@RequestBody DriverDto driverDto) throws Exception {
		log.info("Update Driver Details");
		Driver driver = driverService.updateDriver(driverDto);
		if (driver != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/get/{driverId}")
	public Driver getDriverById(@PathVariable("driverId") Integer driverId) {
		log.debug("Cab Details");
		try {
		
			return driverService.getDriverById(driverId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("Driver Details Failed To Get");
		}

	}

	@DeleteMapping("/delete/{driverId}")
	public Response deleteDrivers(@PathVariable("driverId") Integer driverId) {
		log.info("Delete Drivers Details");
		boolean isdelete = driverService.deleteDriver(driverId);
		if (isdelete)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

}
