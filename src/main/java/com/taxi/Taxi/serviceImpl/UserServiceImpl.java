package com.taxi.Taxi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.Taxi.dao.UserDao;
import com.taxi.Taxi.dto.UserDto;
import com.taxi.Taxi.dto.UserLogInDto;
import com.taxi.Taxi.model.User;
import com.taxi.Taxi.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserDao userDao;

	@Override
	public User saveOrUpdate(UserDto userDto) {
		log.debug("Save Driver Details");
		try {
			User userDetails = modelMapper.map(userDto, User.class);
			return userDao.save(userDetails);
		} catch (Exception e) {
			log.error(e.getMessage());

			throw new RuntimeException("Failed To save");
		}
	}
	
	@Override
	public User signIn(UserLogInDto userLogInDto ) throws Exception {
		try {
			return userDao.findByemailAndPassword(userLogInDto.getEmail(),userLogInDto.getPassword());
			} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("User not found");
		}
		   
		}
	

	@Override
	public User updateUser(UserDto userDto) throws Exception {
		log.info("Update User Details");
		try {
			User user = userDao.findByuserId(userDto.getUserId());
			if (user != null) {
				user.setUserId(userDto.getUserId());
				user.setUserName(userDto.getUserName());
				user.setPassword(userDto.getPassword());
				user.setMobileNumber(userDto.getMobileNumber());
				return userDao.save(user);

			}
			throw new Exception("UserId failed to Get");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("Update Failed");

		}

	}

	@Override
	public User getUser(Integer userId) throws Exception {
		try {
			return userDao.findByuserId(userId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("User not found");
		}
	}

	@Override
	public boolean deleteUser(Integer userId) {
		log.info("delete User Details");
		try {
			userDao.deleteByuserId(userId);
			return true;
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return false;
		}

	}

}
