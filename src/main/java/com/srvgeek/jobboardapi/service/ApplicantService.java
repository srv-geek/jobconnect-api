package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.ApplicantDao;
import com.srvgeek.jobboardapi.dto.ApplicantDTO;
import com.srvgeek.jobboardapi.entity.Applicant;

@Service
public class ApplicantService {

	@Autowired
	private ApplicantDao applicantDao;

	// Register (returns full entity — keep this if you're saving directly)
	public Applicant registerApplicant(Applicant applicant) {
		return applicantDao.save(applicant);
	}

	// Get single applicant as DTO
	public ApplicantDTO getApplicantDTOById(Long id) {
		Applicant applicant = applicantDao.findById(id).orElseThrow(() -> new RuntimeException("Applicant not found"));

		return mapToDTO(applicant);
	}

	// Get all applicants as DTO list
	public List<ApplicantDTO> getAllApplicantDTOs() {
		List<Applicant> applicants = applicantDao.findAll();

		return applicants.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Delete applicant by ID
	public void deleteApplicant(Long id) {
		applicantDao.deleteById(id);
	}

	private ApplicantDTO mapToDTO(Applicant applicant) {
		ApplicantDTO dto = new ApplicantDTO();
		dto.setId(applicant.getId());
		dto.setName(applicant.getName());
		dto.setEmail(applicant.getEmail());
		dto.setResumeUrl(applicant.getResumeUrl());
		return dto;
	}
}
