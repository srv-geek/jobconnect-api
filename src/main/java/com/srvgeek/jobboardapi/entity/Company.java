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
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;

	@OneToMany(mappedBy = "company")
	private List<Job> jobs;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Company() {

	}

	public Company(Long id, String name, String location, List<Job> jobs, User user) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.jobs = jobs;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", location=" + location + ", jobs=" + jobs + ", user=" + user
				+ "]";
	}

}
