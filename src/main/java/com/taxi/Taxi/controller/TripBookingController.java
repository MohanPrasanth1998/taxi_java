package com.taxi.Taxi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.Taxi.dto.TripBookingDto;
import com.taxi.Taxi.dto.TripSearchDto;
import com.taxi.Taxi.model.TripBooking;
import com.taxi.Taxi.service.TripBookingService;
import com.taxi.Taxi.util.ExceptionMessageUtil;
import com.taxi.Taxi.util.Response;
import com.taxi.Taxi.util.ResponseMessageUtil;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/booking")
@RestController
@Slf4j
public class TripBookingController {
	
	
	@Autowired
	private TripBookingService tripBookingService;

	@PostMapping("/save")
	public Response saveOrUpdate(@RequestBody TripBookingDto tripBookingDto) {
		TripBooking booking = tripBookingService.saveOrUpdate(tripBookingDto);
		if (booking != null)
			return new Response(new Date(), ResponseMessageUtil.SUCCESS, HttpStatus.OK);
		return new Response(new Date(), ResponseMessageUtil.FAILED, HttpStatus.BAD_REQUEST);

	}
	
	
	
	@GetMapping("/get/{cabId}")
	public List<TripBookingDto> getAllTripsByCab(@PathVariable("cabId") Integer cabId){
    	log.debug("List Of TripDetails ");
    	try {
    		return tripBookingService.getAllTribsByCab(cabId);
		} catch (Exception e) {
		log.error(e.getMessage());
		throw new RuntimeException(ExceptionMessageUtil.LIST_OF_BOOKING_CABS_FAILED_TO_GET_ON_CONTROLLER);
		}
	}
	
	
	@PostMapping("/search")
	public List<TripBooking> getAllTripsBypickupLocationAnddropLocationAndfromDateTime(
			@RequestBody TripSearchDto tripSearchDto){
		log.debug("List of Trips");
		try {
			return tripBookingService.getAllTripsBypickupLocationAnddropLocationAndfromDateTime(tripSearchDto);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(ExceptionMessageUtil.LIST_OF_BOOKING_LOCATION_FAILED_TO_GET_ON_CONTROLLER);
			
		}	
	}
	
	
	
	@GetMapping("/get/{cabId}/{userId}")
	public List<TripBookingDto> getAllTripsByCabAndUser(@PathVariable("cabId") Integer cabId,@PathVariable("userId") Integer userId){
    	log.debug("List Of Cab And User Details ");
    	try {
    		return tripBookingService.getAllTribsByCabAndUser(cabId, userId);
		} catch (Exception e) {
		log.error(e.getMessage());
		throw new RuntimeException(ExceptionMessageUtil.LIST_OF_BOOKING_CABS_AND_USER_FAILED_TO_GET_ON_CONTROLLER);
		}
	}
	

}
