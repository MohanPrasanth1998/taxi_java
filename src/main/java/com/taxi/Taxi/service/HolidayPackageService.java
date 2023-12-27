package com.taxi.Taxi.service;

import java.util.List;

import com.taxi.Taxi.dto.HolidayPackageDto;
import com.taxi.Taxi.model.HolidayPackage;

public interface HolidayPackageService {
	
	List<HolidayPackage> getAllPackages();
	//List<HolidayPackageDto> getPackageById(Long packageId);//findBypackageId
	boolean deletePackage(Long packageId);
	HolidayPackage save(HolidayPackageDto holidayPackagedto);
	HolidayPackage update(HolidayPackageDto holidayPackageDto) throws Exception;
	List<HolidayPackageDto> getPackageById(long packageId);
	

}
