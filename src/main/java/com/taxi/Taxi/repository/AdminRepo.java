package com.taxi.Taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Taxi.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	Admin findByadminId(Integer adminId);

	void deleteByadminId(Integer adminId);

}
