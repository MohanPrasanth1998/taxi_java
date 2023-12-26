package com.taxi.Taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Taxi.model.Cab;

@Repository
public interface CabRepo extends JpaRepository<Cab, Integer>{

	Cab findBycabId(Integer cabId);

	void deleteBycabId(Integer cabId);
}
