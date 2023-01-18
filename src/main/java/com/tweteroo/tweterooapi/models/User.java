package com.tweteroo.tweterooapi.models;

import com.tweteroo.tweterooapi.DTO.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
// Tabela `User` keyword reservado do banco de dados
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, nullable = false)
	private String username;

	@Column(length = 100, nullable = false)
	private String avatar;

	public User(UserDTO userDTO) {
		this.username = userDTO.username();
		this.avatar = userDTO.avatar();
	}

}
