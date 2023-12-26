package com.taxi.Taxi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Payment {
	
	
	@Id
	private String paymentId;
	private Integer paymentAmount;
	private String paymentStatus;
	private String paymentMethod;
	private String transactionTime;
	private String transactionDate;
	private String paymentResponseStatus;
	
	@ManyToOne(targetEntity = Cab.class)
	@JoinColumn(name="cab_id",referencedColumnName = "cabId")
	private Cab cab;

}
