package com.srvgeek.jobboardapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srvgeek.jobboardapi.entity.Application;

public interface ApplicationDao extends JpaRepository<Application, Long> {

	List<Application> findByApplicantId(Long applicantId);

	List<Application> findByJobId(Long jobId);

	boolean existsByApplicantIdAndJobId(Long applicantId, Long jobId); // to prevent duplicates
}
