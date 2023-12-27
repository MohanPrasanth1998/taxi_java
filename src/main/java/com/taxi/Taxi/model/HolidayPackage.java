package com.taxi.Taxi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HolidayPackage {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long packageId;
    private String packageName;
    private String destination;
    private String price;

}
