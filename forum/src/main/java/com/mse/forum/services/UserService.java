package com.mse.forum.services;

import com.mse.forum.dto.UserDTO;

public interface UserService {

	boolean saveUser(UserDTO user);

	UserDTO getUser(UserDTO user);

}
