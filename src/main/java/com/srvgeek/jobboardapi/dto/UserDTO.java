package com.srvgeek.jobboardapi.dto;

public class UserDTO {

	private Long id;
	private String email;
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", email=" + email + ", role=" + role + "]";
	}

}
