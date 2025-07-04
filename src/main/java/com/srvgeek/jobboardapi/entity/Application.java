package com.srvgeek.jobboardapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "applicant_id")
	private Applicant applicant;

	private String resumeLink;
	private String status;

	public Application() {

	}

	public Application(Long id, Job job, Applicant applicant, String resumeLink, String status) {
		super();
		this.id = id;
		this.job = job;
		this.applicant = applicant;
		this.resumeLink = resumeLink;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getResumeLink() {
		return resumeLink;
	}

	public void setResumeLink(String resumeLink) {
		this.resumeLink = resumeLink;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", job=" + job + ", applicant=" + applicant + ", resumeLink=" + resumeLink
				+ ", status=" + status + "]";
	}

}
