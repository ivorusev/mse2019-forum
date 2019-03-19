package com.mse.forum.services.impl;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.UserDTO;
import com.mse.forum.mappers.UsersMapper;
import com.mse.forum.persistance.UsersRepository;
import com.mse.forum.persistance.entities.Roles;
import com.mse.forum.persistance.entities.UserEntity;
import com.mse.forum.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UsersRepository usersRepository;

	private UsersMapper mapper;

	@Override
	public boolean saveUser(UserDTO user) {
		UserEntity entity = mapper.toEntity(user);
		entity.setRole(Roles.USER);
		usersRepository.save(entity);
		return true;
	}

}