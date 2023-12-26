package com.taxi.Taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Taxi.model.Cab;
import com.taxi.Taxi.model.TripBooking;
import com.taxi.Taxi.model.User;

@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking, Integer>{
	
	List<TripBooking> findBycab(Cab cab);
	
	List <TripBooking> findByuser(User user);
	
	List<TripBooking> findBycabAndUser(Cab cab, User user);

	TripBooking findBytripBookingId(Integer tripBookingId);


}
