package com.mse.forum.persistance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.forum.persistance.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

}
