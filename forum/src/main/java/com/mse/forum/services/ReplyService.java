package com.mse.forum.services;

import java.util.List;

import com.mse.forum.dto.ReplyDTO;

public interface ReplyService {

	boolean save(ReplyDTO dto);

	List<ReplyDTO> getByTopicId(Long id);

}
