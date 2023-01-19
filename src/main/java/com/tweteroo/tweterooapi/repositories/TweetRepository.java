package com.tweteroo.tweterooapi.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweterooapi.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

	public Page<Tweet> findAllByUserId(Long userId, Pageable pageable);

}
