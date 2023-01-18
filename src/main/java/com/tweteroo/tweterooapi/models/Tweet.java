package com.tweteroo.tweterooapi.models;

public class Tweet {
	private String username;
	private String avatar;
	private String tweet;

	public Tweet(
		String username,
		String avatar,
		String tweet
	){
		this.username = username;
		this.avatar = avatar;
		this.tweet = tweet;
	}

	public String getUsername() {
		return username;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getTweet() {
		return tweet;
	}

	

	
}
