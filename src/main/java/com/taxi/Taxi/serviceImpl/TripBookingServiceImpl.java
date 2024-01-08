package com.taxi.Taxi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.Taxi.dao.TripBookingDao;
import com.taxi.Taxi.dto.TripBookingDto;
import com.taxi.Taxi.model.Cab;
import com.taxi.Taxi.model.TripBooking;
import com.taxi.Taxi.model.User;
import com.taxi.Taxi.service.CabService;
import com.taxi.Taxi.service.TripBookingService;
import com.taxi.Taxi.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TripBookingServiceImpl implements TripBookingService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private TripBookingDao tripBookingDao;
	@Autowired
	private CabService cabService;
	@Autowired
	private UserService userService;

	@Override
	public TripBooking saveOrUpdate(TripBookingDto tripBookingDto) {
		log.debug("Save Driver Details");
		try {
			TripBooking tripDetails = modelMapper.map(tripBookingDto, TripBooking.class);
			tripDetails.setTotalTravellersCount(
					tripBookingDto.getTravellersAdult() + tripBookingDto.getTravellersChildrens());
			return tripBookingDao.save(tripDetails);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("Failed To save");
		}
	}

	@Override
	public TripBooking updateStatus(boolean bookingStatus, Integer tripBookingId) throws Exception {
		try {
			TripBooking tripBooking = tripBookingDao.findBytripBookingId(tripBookingId);
			if (tripBooking != null) {
				tripBooking.setBookingStatus(bookingStatus);
				// tripBooking.isBookingStatus();
				// tripBooking.setBookingStatus(bookingStatus);
				return tripBookingDao.save(tripBooking);
			}
			throw new Exception("Booking id not found");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Update failed");
		}
	}

	// we need tripBooking List-So we use cab to get the list of each cab
	@Override
	public List<TripBookingDto> getAllTribsByCab(Integer cabId) {
		try {
			// we get cab by using cab Id
			Cab cab = cabService.getCabById(cabId);
			// we use that cab to take details from database ,on that cab connect with which
			// trip
			return tripBookingDao.findBycab(cab).stream().map(trip -> modelMapper.map(trip, TripBookingDto.class))
					.collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}
	}

	@Override
	public List<TripBookingDto> getAllTribsByCabAndUser(Integer cabId, Integer userId) {
		try {
			Cab cab = cabService.getCabById(cabId);
			User user = userService.getUser(userId);
			return tripBookingDao.findBycabAndUser(cab, user).stream()
					.map(trip -> modelMapper.map(trip, TripBookingDto.class)).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}
	}

	@Override
	public List<TripBookingDto> getAllTripsByUser(Integer userId) throws Exception {
		try {
			log.info("List of TripDetails By UserId ");
			User user = userService.getUser(userId);
			return tripBookingDao.findByuser(user).stream().map(trip -> modelMapper.map(trip, TripBookingDto.class))
					.collect(Collectors.toList());

		} catch (Exception e) {
			log.debug(e.getMessage());
			return new ArrayList<>();
		}

	}

	@Override
	public List<TripBooking> getAllTripsBypickupLocationAnddropLocationAndfromDateTime(String pickupLocation,
			String dropLocation, String fromDateTime) {
		try {
			log.info("list Of Details");
			return tripBookingDao.findBypickupLocationAndDropLocationAndFromDateTime(pickupLocation, dropLocation,
					fromDateTime);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}

		
	}

}
