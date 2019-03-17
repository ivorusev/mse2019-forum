package com.mse.forum.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.TopicDTO;
import com.mse.forum.mappers.TopicMapper;
import com.mse.forum.persistance.TopicRepository;
import com.mse.forum.persistance.entities.TopicEntity;
import com.mse.forum.services.TopicService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

	private TopicMapper mapper;

	private TopicRepository repository;

	@Override
	public boolean saveTopic(TopicDTO dto) {
		TopicEntity entity = mapper.toEntity(dto);
		repository.save(entity);
		return true;
	}

	@Override
	public List<TopicDTO> getAll() {
		return repository.findAll()
				.stream()
				.map(entity -> mapper.toDto(entity))
				.collect(Collectors.toList());
	}

	@Override
	public TopicDTO findByTitle(String title) {
		return mapper.toDto(repository.findByTitle(title));
	}

	@Override
	public TopicDTO findById(Long id) {
		return mapper.toDto(repository.findById(id)
				.get());
	}

}
