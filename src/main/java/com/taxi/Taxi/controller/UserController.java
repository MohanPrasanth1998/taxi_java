package com.taxi.Taxi.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taxi.Taxi.dto.UserDto;
import com.taxi.Taxi.dto.UserLogInDto;
import com.taxi.Taxi.model.User;
import com.taxi.Taxi.service.UserService;
import com.taxi.Taxi.util.Response;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public Response saveOrUpdate(@RequestBody UserDto userDto) {
		User user = userService.saveOrUpdate(userDto);
		if (user != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}
	
	@PostMapping("/signin")
	public Response saveSigIn(@RequestBody UserLogInDto userLogInDto ) throws Exception {
		User user = userService.signIn(userLogInDto);
		if (user != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK,user);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}


	@PutMapping("/update")
	public Response updateUser(@RequestBody UserDto userDto) throws Exception {

		User user = userService.updateUser(userDto);
		if (user != null)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/get/{userId}")
	public User getuserById(@PathVariable("userId") Integer userId) {
		log.debug("User Details");
		try {
			return userService.getUser(userId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException("User Details Failed To Get");
		}

	}

	@DeleteMapping("/delete/{userId}")
	public Response deleteUserById(@PathVariable("userId") Integer userId) {
		log.info("Delete User");
		boolean isdelete = userService.deleteUser(userId);
		if (isdelete)
			return new Response(new Date(), "SUCCESS", HttpStatus.OK);
		return new Response(new Date(), "FAILED", HttpStatus.BAD_REQUEST);

	}

}
