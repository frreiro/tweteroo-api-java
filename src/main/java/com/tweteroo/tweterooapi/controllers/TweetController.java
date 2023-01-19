package com.tweteroo.tweterooapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweterooapi.DTO.SendTweetDTO;
import com.tweteroo.tweterooapi.models.Tweet;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.repositories.TweetRepository;
import com.tweteroo.tweterooapi.repositories.UserRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TweetRepository tweetRepository;

	@PostMapping
	public String createTweet(@RequestBody SendTweetDTO sendTweetDTO) {
		User user = userRepository.findByUsername(sendTweetDTO.username());
		if (user == null) {
			return "User not found";
		}

		Tweet tweet = new Tweet(user, sendTweetDTO.tweet());
		tweetRepository.save(tweet);
		return "OK";
	}

	@GetMapping
	public List<Tweet> getTweets() {
		return tweetRepository.findAll();
	}

	@GetMapping("/{username}")
	public List<Tweet> getTweetsByUsername(@PathVariable String username) {
		User user = userRepository.findByUsername(username);
		return tweetRepository.findByUserId(user.getId());
	}
}
