package com.taxi.Taxi.model;

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
	private String toDateTime;
	@NotNull
	private float distanceInKm;
	@JsonIgnore
	private String currStatus;
	private String estimateFare; 
	private String cancelReason;
	private String bookingStatus;
	private String schedulePickupTime;
	
	
		
	@ManyToOne(cascade = CascadeType.REMOVE,targetEntity = User.class)
	@JoinColumn(name="user_id",referencedColumnName = "userId")
	@JsonIgnore
	private User user;
	
	@ManyToOne(targetEntity = Cab.class, cascade = CascadeType.REMOVE)
	@JoinColumn(name="cab_id",referencedColumnName = "cabId")
	@JsonIgnore
	private Cab cab;

	

}
