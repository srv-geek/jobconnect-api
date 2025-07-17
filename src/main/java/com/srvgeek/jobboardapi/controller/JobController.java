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

import com.srvgeek.jobboardapi.dto.JobDTO;
import com.srvgeek.jobboardapi.entity.Job;
import com.srvgeek.jobboardapi.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@PostMapping("/post")
	public JobDTO postJob(@RequestBody JobDTO jobDTO) {
		Job savedJob = jobService.createJobFromDTO(jobDTO);
		return jobService.getJobDTOById(savedJob.getId());
	}

	@GetMapping
	public List<JobDTO> getAllJobs() {
		return jobService.getAllJobDTOs();
	}

	@GetMapping("/{id}")
	public JobDTO getJob(@PathVariable Long id) {
		return jobService.getJobDTOById(id);
	}

	@GetMapping("/location/{location}")
	public List<JobDTO> getJobsByLocation(@PathVariable String location) {
		return jobService.getJobsByLocation(location);
	}

	@GetMapping("/type/{jobType}")
	public List<JobDTO> getJobsByType(@PathVariable String jobType) {
		return jobService.getJobsByType(jobType);
	}

	@DeleteMapping("/{id}")
	public String deleteJob(@PathVariable Long id) {
		jobService.deleteJob(id);
		return "Job deleted successfully";
	}
}
