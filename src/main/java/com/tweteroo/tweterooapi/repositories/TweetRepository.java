package com.tweteroo.tweterooapi.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweterooapi.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

	public List<Tweet> findAllByUserId(Long userId, Sort sort);

}
