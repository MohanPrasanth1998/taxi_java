package com.taxi.Taxi.dto;

import lombok.Data;

@Data
public class DriverDto {
	
	private Integer driverId;
	private String driverName;
	private String licenceNo;
	private String rating;
	private String curDriverStatus;
	private Integer totalRides;
	private String totalEarning;
	private String averageRatings;
	private Integer acceptRideCount;
	private Integer rejectRideCount;
	private String knownLanguage;
	private String cabId;

}
