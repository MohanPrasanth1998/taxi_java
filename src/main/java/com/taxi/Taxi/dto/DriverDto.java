package com.taxi.Taxi.dto;

import lombok.Data;

@Data
public class DriverDto {
	
	private Integer driverId;
	private String driverName;
	private String licenceNo;
	private Integer rating;
	private boolean curDriverStatus;
	private Integer totalRides;
	private long totalEarning;
	private Integer averageRatings;
	private Integer acceptRideCount;
	private Integer rejectRideCount;
	private String knownLanguage;
	
	private String cabId;

}
