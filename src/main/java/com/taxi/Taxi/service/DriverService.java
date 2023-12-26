package com.taxi.Taxi.service;

import com.taxi.Taxi.dto.DriverDto;
import com.taxi.Taxi.model.Driver;

public interface DriverService {

	Driver saveOrUpdate(DriverDto driverDto);

	Driver getDriverById(Integer driverId) throws Exception;

	boolean deleteDriver(Integer driverId);

	Driver updateDriver(DriverDto driverDto) throws Exception;

}
