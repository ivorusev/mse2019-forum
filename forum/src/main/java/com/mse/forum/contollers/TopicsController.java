package com.mse.forum.contollers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.TopicDTO;
import com.mse.forum.services.TopicService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/topics")
public class TopicsController {

	private TopicService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<TopicDTO> getAll() {
		List<TopicDTO> result = service.getAll();
		return result;
	}

	@RequestMapping(path = "/{title}/", method = RequestMethod.GET)
	public TopicDTO getTopicByTitle(@PathVariable String title) {
		return service.findByTitle(title);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void createTopic(@RequestBody TopicDTO topic) {
		service.saveTopic(topic);
		return;
	}

}
