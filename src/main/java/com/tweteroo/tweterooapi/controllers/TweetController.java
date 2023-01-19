package com.tweteroo.tweterooapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TweetRepository tweetRepository;

	@PostMapping
	public String createTweet(@Valid @RequestBody SendTweetDTO sendTweetDTO) {
		User user = userRepository.findByUsername(sendTweetDTO.username());
		if (user == null) {

			// TODO: retornar status code correto
			return "User not found";
		}

		Tweet tweet = new Tweet(user, sendTweetDTO.tweet());
		tweetRepository.save(tweet);
		return "OK";
	}

	@GetMapping
	public Page<Tweet> getTweets(@RequestParam(value = "page", defaultValue = "0") int page) {
		System.out.println(page);
		// TODO: check if is pattern return the Page Object or a List
		Pageable pageable = PageRequest.of(page, 5);
		// Page pageTweet = tweetRepository.findAll(pageable);
		// return pageTweet.getContent();
		return tweetRepository.findAll(pageable);
	}

	@GetMapping("/{username}")
	public Page<Tweet> getTweetsByUsername(
			@PathVariable String username,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			// TODO: retornar que o usuário não existe;
		}
		Pageable pageable = PageRequest.of(page, 5);

		return tweetRepository.findAllByUserId(user.getId(), pageable);
	}
}
