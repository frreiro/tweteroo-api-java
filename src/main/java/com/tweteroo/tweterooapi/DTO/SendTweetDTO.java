package com.tweteroo.tweterooapi.DTO;

import jakarta.validation.constraints.NotBlank;

public record SendTweetDTO(
		@NotBlank String username,
		@NotBlank String tweet) {

}
