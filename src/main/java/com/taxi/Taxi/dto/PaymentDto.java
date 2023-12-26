package com.taxi.Taxi.dto;

import java.util.Date;
import lombok.Data;

@Data
public class PaymentDto {
	private String paymentId;
	private Integer paymentAmount;
	private String paymentStatus;
	private String paymentMethod;
	private String transactionTime;
	private Date transactionDate;
	private String paymentResponseStatus;
	private String cabId;

}
