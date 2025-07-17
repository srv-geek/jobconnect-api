package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.CompanyDao;
import com.srvgeek.jobboardapi.dao.UserDao;
import com.srvgeek.jobboardapi.dto.CompanyDTO;
import com.srvgeek.jobboardapi.entity.Company;
import com.srvgeek.jobboardapi.entity.User;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private UserDao userDao;

	public Company createCompanyFromDTO(CompanyDTO companyDTO) {
		Company company = new Company();
		company.setName(companyDTO.getName());
		company.setLocation(companyDTO.getLocation());
		company.setDescription(companyDTO.getDescription());
		company.setIndustry(companyDTO.getIndustry());

		Long userId = companyDTO.getUserId();
		User user = userDao.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
		company.setUser(user);

		return companyDao.save(company);
	}

	public CompanyDTO getCompanyDTOById(Long id) {
		Company company = companyDao.findById(id)
				.orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
		return mapToDTO(company);
	}

	public List<CompanyDTO> getAllCompanyDTOs() {
		List<Company> companies = companyDao.findAll();
		return companies.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public void deleteCompany(Long id) {
		companyDao.deleteById(id);
	}

	private CompanyDTO mapToDTO(Company company) {
		CompanyDTO dto = new CompanyDTO();
		dto.setId(company.getId());
		dto.setName(company.getName());
		dto.setLocation(company.getLocation());
		dto.setDescription(company.getDescription());
		dto.setIndustry(company.getIndustry());
		dto.setUserId(company.getUser().getId());
		return dto;
	}
}
