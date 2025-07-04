package com.srvgeek.jobboardapi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String jobType;
	private String location;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy = "job")
	private List<Application> applications;

	public Job() {

	}

	public Job(Long id, String title, String description, String jobType, String location, Company company,
			List<Application> applications) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.jobType = jobType;
		this.location = location;
		this.company = company;
		this.applications = applications;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", jobType=" + jobType
				+ ", location=" + location + ", company=" + company + ", applications=" + applications + "]";
	}

}
