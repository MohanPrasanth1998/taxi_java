package com.taxi.Taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Taxi.model.HolidayPackage;

@Repository
public interface HolidayPackageRepo extends JpaRepository<HolidayPackage, Long> {

    List<HolidayPackage> findAll();
	List <HolidayPackage> findBypackageId(Long packageId);
	void  deleteBypackageId(Long packageId);
	

}
