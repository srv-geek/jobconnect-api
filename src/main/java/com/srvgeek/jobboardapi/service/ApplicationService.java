package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.ApplicantDao;
import com.srvgeek.jobboardapi.dao.ApplicationDao;
import com.srvgeek.jobboardapi.dao.JobDao;
import com.srvgeek.jobboardapi.dto.ApplicationDTO;
import com.srvgeek.jobboardapi.entity.Applicant;
import com.srvgeek.jobboardapi.entity.Application;
import com.srvgeek.jobboardapi.entity.Job;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationDao applicationDao;

	@Autowired
	private ApplicantDao applicantDao;

	@Autowired
	private JobDao jobDao;

	public ApplicationDTO applyToJob(Application application) {
		Long applicantId = application.getApplicant().getId();
		Long jobId = application.getJob().getId();

		boolean exists = applicationDao.existsByApplicantIdAndJobId(applicantId, jobId);

		if (exists) {
			throw new RuntimeException("Applicant already applied to this job");
		}

		Applicant applicant = applicantDao.findById(applicantId)
				.orElseThrow(() -> new RuntimeException("Applicant not found with ID: " + applicantId));

		Job job = jobDao.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));

		application.setApplicant(applicant);
		application.setJob(job);

		Application savedApplication = applicationDao.save(application);

		return mapToDTO(savedApplication);
	}

	public List<ApplicationDTO> getApplicationsByApplicant(Long applicantId) {
		List<Application> list = applicationDao.findByApplicantId(applicantId);
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public List<ApplicationDTO> getApplicationsByJob(Long jobId) {
		List<Application> list = applicationDao.findByJobId(jobId);
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public List<ApplicationDTO> getAllApplications() {
		List<Application> list = applicationDao.findAll();
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public void deleteApplication(Long id) {
		applicationDao.deleteById(id);
	}

	// Manual mapping logic
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
