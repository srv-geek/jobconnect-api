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

import com.srvgeek.jobboardapi.dto.ApplicantDTO;
import com.srvgeek.jobboardapi.entity.Applicant;
import com.srvgeek.jobboardapi.service.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

	@Autowired
	private ApplicantService applicantService;

	@PostMapping("/register")
	public Applicant registerApplicant(@RequestBody Applicant applicant) {
		return applicantService.registerApplicant(applicant);
	}

	@GetMapping
	public List<ApplicantDTO> getAllApplicants() {
		return applicantService.getAllApplicantDTOs();
	}

	@GetMapping("/{id}")
	public ApplicantDTO getApplicant(@PathVariable Long id) {
		return applicantService.getApplicantDTOById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteApplicant(@PathVariable Long id) {
		applicantService.deleteApplicant(id);
		return "Applicant deleted successfully";
	}
}
