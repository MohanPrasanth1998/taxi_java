package com.taxi.Taxi.service;

import java.util.List;

import com.taxi.Taxi.dto.TripBookingDto;
import com.taxi.Taxi.model.TripBooking;

public interface TripBookingService {
	
	TripBooking saveOrUpdate(TripBookingDto TripBookingDto);

	List<TripBookingDto> getAllTribsByCab(Integer cabId);

	List<TripBookingDto> getAllTribsByCabAndUser(Integer cabId, Integer userId);

	TripBooking updateStatus(String bookingStatus, Integer tripBookingId) throws Exception;

	List<TripBookingDto> getAllTripsByUser(Integer userId) throws Exception;
	

}
