package com.taxi.Taxi.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taxi.Taxi.dto.PaymentDto;
import com.taxi.Taxi.model.Payment;
import com.taxi.Taxi.service.PaymentService;
import com.taxi.Taxi.util.Response;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/save")
	public Response saveOrUpdate(@RequestBody PaymentDto paymentDto) {
		Payment pay = paymentService.saveOrUpdate(paymentDto);
		if (pay != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}
	
	
	@GetMapping("/get/cab")
	public List<PaymentDto> getAllPaymentByCab(@PathVariable("cabId") Integer cabId){
    	log.debug("List Of PaymentDetails ");
    	try {
    		return paymentService.getAllPaymentsByCab(cabId);
		} catch (Exception e) {
		log.error(e.getMessage());
		throw new RuntimeException("Cab Payment List Failed To Get");
		}
	}
	

}
