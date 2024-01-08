package com.taxi.Taxi.dto;

import lombok.Data;

@Data
public class CabDto {
	private Integer cabId;
	private String vehicleType;
	private String vehicleName;
	private String vehicleNumber;
	private float  perKmRate;
	private String vehicleCurLocation;
	private boolean vehicleCurStatus;
	

}
