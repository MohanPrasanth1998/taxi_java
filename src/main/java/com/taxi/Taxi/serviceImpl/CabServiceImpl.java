package com.taxi.Taxi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.Taxi.dao.CabDao;
import com.taxi.Taxi.dto.CabDto;
import com.taxi.Taxi.model.Cab;
import com.taxi.Taxi.service.CabService;
import com.taxi.Taxi.util.ExceptionMessageUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CabServiceImpl implements CabService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CabDao cabDao;

	@Override
	public Cab saveOrUpdate(CabDto cabDto) {

		log.debug("Save Admin Details");
		try {
			Cab cabDetails = modelMapper.map(cabDto, Cab.class);
			return cabDao.save(cabDetails);
		} catch (Exception e) {
			log.error(e.getMessage());
			
			throw new RuntimeException(ExceptionMessageUtil.CAB_DETAILS_FAILED_TO_SAVE);
		}
	}

	@Override
	public Cab updateCab(CabDto cabDto) throws Exception {
		log.info("Update Cab Details");
		try {
			//Cab cab = cabDao.findBycabId(cabDto.getCabId());
			Cab cab = new Cab();
			if (cab != null) {
				
				//cab.setVehicleCurStatus(cabDto.getVehicleCurStatus());
				cab.setVehicleCurLocation(cabDto.getVehicleCurLocation());
				cab.setVehicleType(cabDto.getVehicleType());
				cab.setPerKmRate(cabDto.getPerKmRate());
				cab.setCabId(cabDto.getCabId());
				cab.setVehicleName(cabDto.getVehicleName());
				return cabDao.save(cab);
			}
			throw new Exception(ExceptionMessageUtil.CABID_FAILED_TO_GET);

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(ExceptionMessageUtil.CAB_UPDATE_FAILED);
		}

	}

	@Override
	public Cab getCabById(Integer cabId) throws Exception {
		try {
			return cabDao.findBycabId(cabId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(ExceptionMessageUtil.CAB_NOT_FOUND_BY_ID);
		}
	}

	@Override
	public boolean deleteCab(Integer cabId) {
		try {
			cabDao.deleteBycabId(cabId);
			return true;

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return false;
		}

	}

}
