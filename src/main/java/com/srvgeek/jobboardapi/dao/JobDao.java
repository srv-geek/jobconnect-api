package com.srvgeek.jobboardapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srvgeek.jobboardapi.entity.Job;

public interface JobDao extends JpaRepository<Job, Long> {

	List<Job> findByLocation(String location);

	List<Job> findByJobType(String jobType);

	List<Job> findByCompanyId(Long companyId); // list jobs by a company
}
