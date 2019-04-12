package com.mse.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This object will be used to create a reply with the connected topic.
 * 
 * @author ivo.rusev
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyWithTopicDTO {

	private TopicDTO topic;

	private String replyContent;
	private Long userId;

}
