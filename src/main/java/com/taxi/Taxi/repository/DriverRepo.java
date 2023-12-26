package com.taxi.Taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Taxi.model.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {

	Driver findByDriverId(Integer driverId);

	Driver findBydriverId(Integer driverId);

	void deleteBydriverId(Integer driverId);

}
