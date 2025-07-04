package com.srvgeek.jobboardapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srvgeek.jobboardapi.entity.Applicant;

public interface ApplicantDao extends JpaRepository<Applicant, Long>{

}
