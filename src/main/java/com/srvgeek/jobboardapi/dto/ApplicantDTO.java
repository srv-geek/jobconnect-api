package com.srvgeek.jobboardapi.dto;

public class ApplicantDTO {

	private Long id;
	private String name;
	private String email;
	private String resumeUrl;
	private String skills;
	private String experience;
	private Long userId;

	public ApplicantDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResumeUrl() {
		return resumeUrl;
	}

	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ApplicantDTO [id=" + id + ", name=" + name + ", email=" + email + ", resumeUrl=" + resumeUrl
				+ ", skills=" + skills + ", experience=" + experience + ", userId=" + userId + "]";
	}

}
