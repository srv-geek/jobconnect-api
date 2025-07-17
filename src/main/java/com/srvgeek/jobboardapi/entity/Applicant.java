package com.srvgeek.jobboardapi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String resumeUrl;
	private String skills;
	private String experience;

	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Applicant() {
	}

	public Applicant(Long id, String name, String email, String resumeUrl, String skills, String experience,
			User user) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.resumeUrl = resumeUrl;
		this.skills = skills;
		this.experience = experience;
		this.user = user;
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

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", email=" + email + ", resumeUrl=" + resumeUrl + ", skills="
				+ skills + ", experience=" + experience + ", user=" + (user != null ? user.getId() : "null") + "]";
	}
}
