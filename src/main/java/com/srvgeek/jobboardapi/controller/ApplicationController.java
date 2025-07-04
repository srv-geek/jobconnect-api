package com.srvgeek.jobboardapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srvgeek.jobboardapi.dto.ApplicationDTO;
import com.srvgeek.jobboardapi.entity.Application;
import com.srvgeek.jobboardapi.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/apply")
	public ApplicationDTO applyToJob(@RequestBody Application application) {
		return applicationService.applyToJob(application);
	}

	@GetMapping("/applicant/{applicantId}")
	public List<ApplicationDTO> getApplicationsByApplicant(@PathVariable Long applicantId) {
		return applicationService.getApplicationsByApplicant(applicantId);
	}

	@GetMapping("/job/{jobId}")
	public List<ApplicationDTO> getApplicationsByJob(@PathVariable Long jobId) {
		return applicationService.getApplicationsByJob(jobId);
	}

	@GetMapping
	public List<ApplicationDTO> getAllApplications() {
		return applicationService.getAllApplications();
	}

	@DeleteMapping("/{id}")
	public String deleteApplication(@PathVariable Long id) {
		applicationService.deleteApplication(id);
		return "Application deleted successfully";
	}
}
