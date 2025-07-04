package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.CompanyDao;
import com.srvgeek.jobboardapi.dto.CompanyDTO;
import com.srvgeek.jobboardapi.entity.Company;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	public Company createCompany(Company company) {
		return companyDao.save(company);
	}

	public CompanyDTO getCompanyDTOById(Long id) {
		Company company = companyDao.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
		return mapToDTO(company);
	}

	public List<CompanyDTO> getAllCompanyDTOs() {
		List<Company> list = companyDao.findAll();
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public void deleteCompany(Long id) {
		companyDao.deleteById(id);
	}

	private CompanyDTO mapToDTO(Company company) {
		CompanyDTO dto = new CompanyDTO();
		dto.setId(company.getId());
		dto.setName(company.getName());
		dto.setLocation(company.getLocation());
		return dto;
	}
}
