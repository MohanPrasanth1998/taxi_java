package com.taxi.Taxi.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class TripBooking {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	@NotNull
	private String pickupLocation;
	@NotNull
	private String fromDateTime;
	@NotNull
	private String dropLocation;       
	@NotNull
	private Date toDateTime;
	@NotNull
	private float distanceInKm;//backend
	private String estimateFare; //backend
	private String cancelReason;
	private boolean bookingStatus = true;
	private String schedulePickupTime;//backend
	private String scheduleDepatureTime;
	private String conformationCode;//backend
	private long travellersAdult;
	private long travellersChildrens;
	private long totalTravellersCount;//backend

	
		
	@ManyToOne(cascade = CascadeType.REMOVE,targetEntity = User.class)
	@JoinColumn(name="user_id",referencedColumnName = "userId")
	@JsonIgnore
	private User user;
	
	@ManyToOne(targetEntity = Cab.class, cascade = CascadeType.REMOVE)
	@JoinColumn(name="cab_id",referencedColumnName = "cabId")
	@JsonIgnore
	private Cab cab;

	

}
