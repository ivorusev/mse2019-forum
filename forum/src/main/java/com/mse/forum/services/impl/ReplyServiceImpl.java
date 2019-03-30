package com.mse.forum.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.mappers.ReplyMapper;
import com.mse.forum.persistance.RepliesRepository;
import com.mse.forum.persistance.TopicRepository;
import com.mse.forum.persistance.UsersRepository;
import com.mse.forum.persistance.entities.ReplyEntity;
import com.mse.forum.persistance.entities.TopicEntity;
import com.mse.forum.persistance.entities.UserEntity;
import com.mse.forum.services.ReplyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private RepliesRepository replyRepository;

	private TopicRepository topicRepository;

	private ReplyMapper mapper;

	private UsersRepository userRepository;

	@Override
	public boolean save(ReplyDTO dto) {
		Optional<TopicEntity> topic = topicRepository.findById(dto.getTopicId());
		if (!topic.isPresent()) {
			throw new IllegalArgumentException("Tryed to add a reply for non-existant topic.");
		}

		Optional<UserEntity> user = userRepository.findById(dto.getUserId());
		if (!user.isPresent()) {
			throw new IllegalArgumentException("No user found with the given ID.");
		}

		ReplyEntity entity = mapper.toEntity(dto);
		entity.setTopic(topic.get());
		entity.setUser(user.get());

		replyRepository.save(entity);

		return true;
	}

	@Override
	public List<ReplyDTO> getByTopicId(Long id) {
		Optional<TopicEntity> topic = topicRepository.findById(id);
		if (!topic.isPresent()) {
			throw new IllegalArgumentException("Tryed to add a reply for non-existant topic.");
		}
		return topic.get()
				.getReplies()
				.stream()
				.map(mapper::toDto)
				.collect(Collectors.toList());
	}

}
