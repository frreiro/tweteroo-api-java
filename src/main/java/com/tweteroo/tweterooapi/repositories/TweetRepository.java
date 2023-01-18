package com.tweteroo.tweterooapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweterooapi.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
