package com.taxi.Taxi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminDto {
	
	private Integer adminId;
	@NotBlank
	private String userName;
	@NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
	private String password;


}
