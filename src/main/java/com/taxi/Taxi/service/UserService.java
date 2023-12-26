package com.taxi.Taxi.service;

import com.taxi.Taxi.dto.UserDto;
import com.taxi.Taxi.dto.UserLogInDto;
import com.taxi.Taxi.model.User;

public interface UserService {

	User saveOrUpdate(UserDto userDto);

	User getUser(Integer userId) throws Exception;

	boolean deleteUser(Integer userId);

	User updateUser(UserDto userDto) throws Exception;

	
	User signIn(UserLogInDto userLogInDto) throws Exception;

}
