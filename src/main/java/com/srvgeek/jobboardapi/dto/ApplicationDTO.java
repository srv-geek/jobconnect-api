package com.srvgeek.jobboardapi.dto;

public class ApplicationDTO {

	private Long id;

	private Long applicantId;
	private String applicantName;

	private Long jobId;
	private String jobTitle;

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApplicationDTO [id=" + id + ", applicantId=" + applicantId + ", applicantName=" + applicantName
				+ ", jobId=" + jobId + ", jobTitle=" + jobTitle + ", status=" + status + "]";
	}

}
