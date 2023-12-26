package com.taxi.Taxi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	
	
	@OneToOne(targetEntity = Cab.class)
	@JoinColumn(name="cab_id",referencedColumnName = "cabId")
	@JsonIgnore
	private Cab cab;

}
