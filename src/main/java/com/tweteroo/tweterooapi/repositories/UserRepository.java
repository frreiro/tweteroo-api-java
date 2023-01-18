package com.tweteroo.tweterooapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweterooapi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}