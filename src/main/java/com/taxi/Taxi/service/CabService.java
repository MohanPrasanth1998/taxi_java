package com.taxi.Taxi.service;

import com.taxi.Taxi.dto.CabDto;
import com.taxi.Taxi.model.Cab;

public interface CabService {
	
	Cab saveOrUpdate(CabDto cabDto);

	Cab getCabById(Integer cabId) throws Exception;

		
	boolean deleteCab(Integer cabId);

	Cab updateCab(CabDto cabDto) throws Exception;

}
