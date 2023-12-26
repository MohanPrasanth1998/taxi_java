package com.taxi.Taxi.service;

import java.util.List;

import com.taxi.Taxi.dto.PaymentDto;
import com.taxi.Taxi.model.Payment;

public interface PaymentService {
	
	
	Payment saveOrUpdate(PaymentDto  paymentDto);

	List<PaymentDto> getAllPaymentsByCab(Integer cabId);


}
