package com.mse.forum.contollers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.mse.forum.dto.TopicDTO;
import com.mse.forum.services.TopicService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@ControllerAdvice
@RequestMapping(path = "/topics")
public class TopicsController {

	private TopicService service;

	@RolesAllowed("ADMIN")
	@RequestMapping(method = RequestMethod.GET)
	public List<TopicDTO> getAll() {
		List<TopicDTO> result = service.getAll();
		return result;
	}

	@RequestMapping(path = "/title/{title}/", method = RequestMethod.GET)
	public TopicDTO getTopicByTitle(@PathVariable String title) {
		return service.findByTitle(title);
	}

	@RequestMapping(path = "/id/{id}/", method = RequestMethod.GET)
	public TopicDTO getTopicById(@PathVariable Long id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void createTopic(@RequestBody TopicDTO topic) {
		service.saveTopic(topic);
		return;
	}

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT, request);
	}

	private ResponseEntity<Object> handleExceptionInternal(RuntimeException ex, String bodyOfResponse,
			HttpHeaders httpHeaders, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(bodyOfResponse, status);
	}

}
