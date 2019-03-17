package com.mse.forum.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.forum.persistance.entities.TopicEntity;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {

	TopicEntity findByTitle(String title);

}
