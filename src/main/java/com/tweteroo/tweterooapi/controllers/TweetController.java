package com.tweteroo.tweterooapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tweteroo.tweterooapi.DTO.SendTweetDTO;
import com.tweteroo.tweterooapi.models.Tweet;
import com.tweteroo.tweterooapi.services.TweetService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@PostMapping
	public ResponseEntity<String> createTweet(@Valid @RequestBody SendTweetDTO sendTweetDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tweetService.save(sendTweetDTO));
	}

	@GetMapping
	public ResponseEntity<Page<Tweet>> getTweets(@RequestParam(value = "page", defaultValue = "0") int page) {
		return ResponseEntity.ok().body(tweetService.findAll(page));
	}

	@GetMapping("/{username}")
	public ResponseEntity<List<Tweet>> getTweetsByUsername(
			@PathVariable String username,
			@RequestParam(value = "page", defaultValue = "0") int page) {
		return ResponseEntity.ok().body(tweetService.findAllByUserId(username, page));
	}
}
