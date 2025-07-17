package com.srvgeek.jobboardapi.dto;

public class CompanyDTO {

	private Long id;
	private String name;
	private String location;
	private String description;
	private String industry;
	private Long userId; 

	public CompanyDTO() {
	}

	public CompanyDTO(Long id, String name, String location, String description, String industry, Long userId) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.description = description;
		this.industry = industry;
		this.userId = userId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", location=" + location + ", description=" + description
				+ ", industry=" + industry + ", userId=" + userId + "]";
	}
}
