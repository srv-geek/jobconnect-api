package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.ApplicantDao;
import com.srvgeek.jobboardapi.dao.UserDao;
import com.srvgeek.jobboardapi.dto.ApplicantDTO;
import com.srvgeek.jobboardapi.entity.Applicant;
import com.srvgeek.jobboardapi.entity.User;

@Service
public class ApplicantService {

	@Autowired
	private ApplicantDao applicantDao;

	@Autowired
	private UserDao userDao;

	public Applicant registerApplicantFromDTO(ApplicantDTO dto) {
		Applicant applicant = new Applicant();
		applicant.setName(dto.getName());
		applicant.setEmail(dto.getEmail());
		applicant.setResumeUrl(dto.getResumeUrl());
		applicant.setSkills(dto.getSkills());
		applicant.setExperience(dto.getExperience());

		Long userId = dto.getUserId();
		User user = userDao.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
		applicant.setUser(user);

		return applicantDao.save(applicant);
	}

	public ApplicantDTO getApplicantDTOById(Long id) {
		Applicant applicant = applicantDao.findById(id).orElseThrow(() -> new RuntimeException("Applicant not found"));
		return mapToDTO(applicant);
	}

	public List<ApplicantDTO> getAllApplicantDTOs() {
		return applicantDao.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public void deleteApplicant(Long id) {
		applicantDao.deleteById(id);
	}

	private ApplicantDTO mapToDTO(Applicant applicant) {
		ApplicantDTO dto = new ApplicantDTO();
		dto.setId(applicant.getId());
		dto.setName(applicant.getName());
		dto.setEmail(applicant.getEmail());
		dto.setResumeUrl(applicant.getResumeUrl());
		dto.setSkills(applicant.getSkills());
		dto.setExperience(applicant.getExperience());
		if (applicant.getUser() != null) {
			dto.setUserId(applicant.getUser().getId());
		}
		return dto;
	}
}
