package com.tweteroo.tweterooapi.DTO;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
		@NotBlank String username,
		@NotBlank String avatar,
		@NotBlank String tweet) {

}
