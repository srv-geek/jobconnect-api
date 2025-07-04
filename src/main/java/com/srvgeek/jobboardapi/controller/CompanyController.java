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

import com.srvgeek.jobboardapi.dto.CompanyDTO;
import com.srvgeek.jobboardapi.entity.Company;
import com.srvgeek.jobboardapi.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/register")
	public Company createCompany(@RequestBody Company company) {
		return companyService.createCompany(company);
	}

	@GetMapping
	public List<CompanyDTO> getAllCompanies() {
		return companyService.getAllCompanyDTOs();
	}

	@GetMapping("/{id}")
	public CompanyDTO getCompany(@PathVariable Long id) {
		return companyService.getCompanyDTOById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return "Company deleted successfully";
	}
}
