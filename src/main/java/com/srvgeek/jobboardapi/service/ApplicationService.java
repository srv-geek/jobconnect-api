package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.ApplicationDao;
import com.srvgeek.jobboardapi.dto.ApplicationDTO;
import com.srvgeek.jobboardapi.entity.Application;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationDao applicationDao;

	// Register a new application
	public ApplicationDTO applyToJob(Application application) {
		boolean exists = applicationDao.existsByApplicantIdAndJobId(application.getApplicant().getId(),
				application.getJob().getId());

		if (exists) {
			throw new RuntimeException("Applicant already applied to this job");
		}

		Application savedApplication = applicationDao.save(application);
		return mapToDTO(savedApplication);
	}

	// Get all applications by applicantId (as DTOs)
	public List<ApplicationDTO> getApplicationsByApplicant(Long applicantId) {
		List<Application> list = applicationDao.findByApplicantId(applicantId);
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Get all applications by jobId (as DTOs)
	public List<ApplicationDTO> getApplicationsByJob(Long jobId) {
		List<Application> list = applicationDao.findByJobId(jobId);
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Get all applications (as DTOs)
	public List<ApplicationDTO> getAllApplications() {
		List<Application> list = applicationDao.findAll();
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Delete by ID
	public void deleteApplication(Long id) {
		applicationDao.deleteById(id);
	}

	// 🔁 Manual mapping logic
	private ApplicationDTO mapToDTO(Application application) {
		ApplicationDTO dto = new ApplicationDTO();
		dto.setId(application.getId());
		dto.setStatus(application.getStatus());

		if (application.getApplicant() != null) {
			dto.setApplicantId(application.getApplicant().getId());
			dto.setApplicantName(application.getApplicant().getName());
		}

		if (application.getJob() != null) {
			dto.setJobId(application.getJob().getId());
			dto.setJobTitle(application.getJob().getTitle());
		}

		return dto;
	}
}
