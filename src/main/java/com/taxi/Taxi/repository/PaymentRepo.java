package com.taxi.Taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Taxi.model.Cab;
import com.taxi.Taxi.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{
	
	List<Payment> findBycab(Cab cab);

}
