package com.taxi.Taxi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.Taxi.dao.DriverDao;
import com.taxi.Taxi.dto.DriverDto;
import com.taxi.Taxi.model.Driver;
import com.taxi.Taxi.service.DriverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DriverDao driverDao;

	@Override
	public Driver saveOrUpdate(DriverDto driverDto) {

		log.debug("Save Driver Details");
		try {
			Driver driverDetails = modelMapper.map(driverDto, Driver.class);
			return driverDao.save(driverDetails);
		} catch (Exception e) {
			log.error(e.getMessage());

			throw new RuntimeException("Failed To save");
		}
	}

	@Override
	public Driver getDriverById(Integer driverId) throws Exception {

		try {
			return driverDao.findByDriverId(driverId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Driver not found");
		}

	}

	@Override
	public Driver updateDriver(DriverDto driverDto) throws Exception {
		log.info("Update Cab Details");
		try {
			Driver driver =new Driver();
			if (driver != null) {
				driver.setCurDriverStatus(driverDto.isCurDriverStatus());
				driver.setDriverId(driverDto.getDriverId());
				driver.setDriverName(driverDto.getDriverName());
				driver.setKnownLanguage(driverDto.getKnownLanguage());
				return driverDao.save(driver);
			}
			throw new Exception("Admin Id Failed To Get");

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Update failed");
		}

	}

	@Override
	public boolean deleteDriver(Integer driverId) {
		log.info("Delete driver Details");
		try {
			driverDao.deleteBydriverId(driverId);
			return true;

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return false;
		}

	}

}
