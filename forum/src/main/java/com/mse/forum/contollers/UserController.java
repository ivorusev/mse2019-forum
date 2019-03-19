package com.mse.forum.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

	private UserService usersService;

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody UserDTO user) {
		usersService.saveUser(user);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(new String("created"), HttpStatus.OK);
		return responseEntity;
	}
}
