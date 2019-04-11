package com.mse.forum.contollers;

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
	public void login(@RequestBody UserDTO user) {
		usersService.saveUser(user);
	}
}
