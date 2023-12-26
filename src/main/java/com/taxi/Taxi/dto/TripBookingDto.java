package com.taxi.Taxi.dto;

import lombok.Data;

@Data
public class TripBookingDto {
	private Integer tripBookingId;
	private String pickupLocation;
	private String fromDateTime;
	private String dropLocation;
	private String toDateTime;
	private float distanceInKm;
	private String currStatus;
	private String estimateFare; 
	private String cancelReason;
	private String bookingStatus;
	private String schedulePickupTime;
	private String userId;
	private String cabId;

}
