package com.taxi.Taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Taxi.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByuserId(Integer userId);

	void deleteByuserId(Integer userId);

	User findByemailAndPassword(String email, String password);

	


}
