package com.srvgeek.jobboardapi.dto;

public class CompanyDTO {

	private Long id;
	private String name;
	private String location;

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

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

}
