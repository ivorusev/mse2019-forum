package com.mse.forum.services;

import java.util.List;

import com.mse.forum.dto.TopicDTO;

public interface TopicService {

	boolean saveTopic(TopicDTO dto);

	List<TopicDTO> getAll();

	TopicDTO findByTitle(String title);

	TopicDTO findById(Long id);

}
