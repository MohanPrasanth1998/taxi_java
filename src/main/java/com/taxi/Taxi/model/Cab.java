package com.taxi.Taxi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	private String vehicleType;
	private String vehicleName;
	private String vehicleNumber;
	private float  perKmRate;
	private String vehicleCurLocation;
	private boolean vehicleCurStatus;
	

}
