package com.mse.forum.contollers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.services.ReplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/replies")
public class ReplyController {

	private ReplyService service;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void createReply(@RequestBody ReplyDTO reply) {
		service.save(reply);
	}

	@RequestMapping(path = "/id/{id}/", method = RequestMethod.GET)
	public List<ReplyDTO> getRepliesByTopic(@PathVariable Long id) {
		return service.getByTopicId(id);
	}

}
