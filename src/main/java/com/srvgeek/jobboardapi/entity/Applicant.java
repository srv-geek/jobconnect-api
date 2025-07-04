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

	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Applicant() {

	}

	public Applicant(Long id, String name, String email, List<Application> applications, User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.applications = applications;
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
		return "Applicant [id=" + id + ", name=" + name + ", email=" + email + ", resumeUrl=" + resumeUrl
				+ ", applications=" + applications + ", user=" + user + "]";
	}

}
