package com.taxi.Taxi.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDto {
	
	private	Integer userId;
	private String userName;
	private String password;
	private String mobileNumber;
	@Email
	private String email;

}


