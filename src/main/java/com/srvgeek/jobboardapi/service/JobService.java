package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.CompanyDao;
import com.srvgeek.jobboardapi.dao.JobDao;
import com.srvgeek.jobboardapi.dto.JobDTO;
import com.srvgeek.jobboardapi.entity.Company;
import com.srvgeek.jobboardapi.entity.Job;

@Service
public class JobService {

	@Autowired
	private JobDao jobDao;

	@Autowired
	private CompanyDao companyDao;

	public Job createJobFromDTO(JobDTO jobDTO) {
		Job job = new Job();
		job.setTitle(jobDTO.getTitle());
		job.setDescription(jobDTO.getDescription());
		job.setLocation(jobDTO.getLocation());
		job.setJobType(jobDTO.getJobType());

		Long companyId = jobDTO.getCompanyId();
		Company company = companyDao.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));
		job.setCompany(company);

		return jobDao.save(job);
	}

	public JobDTO getJobDTOById(Long id) {
		Job job = jobDao.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
		return mapToDTO(job);
	}

	public List<JobDTO> getAllJobDTOs() {
		return jobDao.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public List<JobDTO> getJobsByLocation(String location) {
		return jobDao.findByLocation(location).stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public List<JobDTO> getJobsByType(String jobType) {
		return jobDao.findByJobType(jobType).stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public void deleteJob(Long id) {
		jobDao.deleteById(id);
	}

	private JobDTO mapToDTO(Job job) {
		JobDTO dto = new JobDTO();
		dto.setId(job.getId());
		dto.setTitle(job.getTitle());
		dto.setDescription(job.getDescription());
		dto.setLocation(job.getLocation());
		dto.setJobType(job.getJobType());

		if (job.getCompany() != null) {
			dto.setCompanyId(job.getCompany().getId());
			dto.setCompanyName(job.getCompany().getName());
		}

		return dto;
	}
}
