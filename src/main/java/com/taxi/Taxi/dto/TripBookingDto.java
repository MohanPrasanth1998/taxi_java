package com.taxi.Taxi.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TripBookingDto {
	private Integer tripBookingId;
	private String pickupLocation;
	private String fromDateTime;
	private String dropLocation;
	private Date toDateTime;
	private float distanceInKm;
	private boolean currStatus;
	private String estimateFare; 
	private String cancelReason;
	private boolean bookingStatus;
	private String schedulePickupTime;
	private long travellersAdult;
	private long travellersChildrens;
	private long totalTravellersCount;
	private String userId;
	private String cabId;

}
