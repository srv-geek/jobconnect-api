package com.srvgeek.jobboardapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srvgeek.jobboardapi.entity.Company;

public interface CompanyDao extends JpaRepository<Company, Long>{

}
