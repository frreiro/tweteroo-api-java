package com.tweteroo.tweterooapi.models;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: passar a classe User ao invés do userId;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String username;

	@Column(length = 100, nullable = false)
	private String avatar;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	private String tweet;

	public Tweet(
			User user,
			String tweet) {
		this.username = user.getUsername();
		this.avatar = user.getAvatar();
		this.userId = user.getId();
		this.tweet = tweet;
	}

}
