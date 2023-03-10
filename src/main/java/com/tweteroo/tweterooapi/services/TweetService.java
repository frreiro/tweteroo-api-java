package com.tweteroo.tweterooapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tweteroo.tweterooapi.DTO.SendTweetDTO;
import com.tweteroo.tweterooapi.exceptions.NotFoundException;
import com.tweteroo.tweterooapi.models.Tweet;
import com.tweteroo.tweterooapi.models.User;
import com.tweteroo.tweterooapi.repositories.TweetRepository;
import com.tweteroo.tweterooapi.repositories.UserRepository;

@Service
public class TweetService {

	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private UserRepository userRepository;

	public String save(SendTweetDTO sendTweetDTO) {
		User user = userRepository.findByUsername(sendTweetDTO.username());
		if (user == null) {

			throw new NotFoundException();
		}

		Tweet tweet = new Tweet(user, sendTweetDTO.tweet());
		tweetRepository.save(tweet);
		return "OK";
	}

	public Page<Tweet> findAll(int page) {
		Pageable pageable = PageRequest.of(page, 5, Sort.by(Direction.DESC, "id"));
		return tweetRepository.findAll(pageable);
	}

	public List<Tweet> findAllByUserId(String username, int page) {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new NotFoundException();
		}
		Sort sort = Sort.by(Direction.DESC, "id");
		return tweetRepository.findAllByUserId(user.getId(), sort);
	}

}
