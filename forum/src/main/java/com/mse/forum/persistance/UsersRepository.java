package com.mse.forum.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.forum.persistance.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}
