package com.mse.forum.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.persistance.entities.ReplyEntity;

@Mapper(componentModel = "spring")
public interface ReplyMapper {

	ReplyEntity toEntity(ReplyDTO dto);

	@Mapping(source = "topic.id", target = "topicId")
	ReplyDTO toDto(ReplyEntity entity);
}
