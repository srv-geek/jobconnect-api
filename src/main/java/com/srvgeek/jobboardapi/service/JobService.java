package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.JobDao;
import com.srvgeek.jobboardapi.dto.JobDTO;
import com.srvgeek.jobboardapi.entity.Job;

@Service
public class JobService {

	@Autowired
	private JobDao jobDao;

	public Job postJob(Job job) {
		return jobDao.save(job);
	}

	public JobDTO getJobDTOById(Long id) {
		Job job = jobDao.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
		return mapToDTO(job);
	}

	// Get all jobs as DTOs
	public List<JobDTO> getAllJobDTOs() {
		return jobDao.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Get jobs by location
	public List<JobDTO> getJobsByLocation(String location) {
		return jobDao.findByLocation(location).stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Get jobs by type
	public List<JobDTO> getJobsByType(String jobType) {
		return jobDao.findByJobType(jobType).stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// Delete job
	public void deleteJob(Long id) {
		jobDao.deleteById(id);
	}

	// Manual mapping logic
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
