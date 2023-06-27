package com.movieApp.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDTO {
	@Id
	private String username;
	private String password;
	private String userRole;
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
