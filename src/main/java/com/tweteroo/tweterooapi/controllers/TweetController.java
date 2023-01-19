package com.tweteroo.tweterooapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweterooapi.DTO.SendTweetDTO;
import com.tweteroo.tweterooapi.models.Tweet;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.repositories.TweetRepository;
import com.tweteroo.tweterooapi.repositories.UserRepository;
import com.tweteroo.tweterooapi.services.TweetService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@PostMapping
	public String createTweet(@Valid @RequestBody SendTweetDTO sendTweetDTO) {
		return tweetService.save(sendTweetDTO);
	}

	@GetMapping
	public Page<Tweet> getTweets(@RequestParam(value = "page", defaultValue = "0") int page) {
		return tweetService.findAll(page);
	}

	@GetMapping("/{username}")
	public List<Tweet> getTweetsByUsername(
			@PathVariable String username,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		return tweetService.findAllByUserId(username, page);
	}
}
