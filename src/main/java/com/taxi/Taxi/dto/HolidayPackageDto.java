package com.taxi.Taxi.dto;

import lombok.Data;

@Data
public class HolidayPackageDto {

	private long packageId;
	private String packageName;
	private String destination;
	private double price;

}
