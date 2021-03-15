package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registry")
public class ProductLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String Username;
	private String Password;

	public ProductLogin() {

	}

	public ProductLogin(String username, String password) {
		this.Username = username;
		this.Password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
}
