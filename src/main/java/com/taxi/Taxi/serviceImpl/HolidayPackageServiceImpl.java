package com.taxi.Taxi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.Taxi.dao.HolidayPackageDao;
import com.taxi.Taxi.dto.HolidayPackageDto;
import com.taxi.Taxi.model.HolidayPackage;
import com.taxi.Taxi.service.HolidayPackageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HolidayPackageServiceImpl implements HolidayPackageService {

	@Autowired
	private HolidayPackageDao holidaypackagedao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HolidayPackage save(HolidayPackageDto holidayPackagedto) {
		log.debug("Save Holiday Packages Details");
		try {
			HolidayPackage packageDetails = modelMapper.map(holidayPackagedto, HolidayPackage.class);
			return holidaypackagedao.save(packageDetails);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("Failed To save");
		}

	}
    
	@Override
	public HolidayPackage update(HolidayPackageDto holidayPackageDto) throws Exception {

		log.debug("Update Holiday Packages Details");
		try {

			//List<HolidayPackage> holidayPackage = holidaypackagedao.findBypackageId(holidayPackageDto.getId());
			HolidayPackage holidayPackage = new HolidayPackage();
			if (holidayPackage != null) {
				holidayPackage.setPackageId(holidayPackageDto.getPackageId());
				holidayPackage.setPackageName(holidayPackageDto.getPackageName());
				holidayPackage.setDestination(holidayPackageDto.getDestination());
				holidayPackage.setPrice(holidayPackageDto.getPrice());
				return holidaypackagedao.save(holidayPackage);
			}

			throw new Exception("Holiday Package Failed To Get");

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Update failed");

		}

	}

	@Override
	public List<HolidayPackage> getAllPackages() {
		log.debug("Get List Of Packages Details");
		return holidaypackagedao.findAll();
	}

	@Override
	public List<HolidayPackageDto> getPackageById(long packageId) {
		log.debug("Get Package By PackageID");
		try {

			return holidaypackagedao.findBypackageId(packageId).stream()
					.map(holiday -> modelMapper.map(holiday, HolidayPackageDto.class)).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}

	}

	@Override
	public boolean deletePackage(Long packageId) {
		log.info("delete package in service");
		try {
			holidaypackagedao.deleteBypackageId(packageId);
			return true;

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return false;
		}

	}

}
