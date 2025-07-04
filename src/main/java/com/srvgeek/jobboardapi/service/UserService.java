package com.srvgeek.jobboardapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srvgeek.jobboardapi.dao.UserDao;
import com.srvgeek.jobboardapi.dto.UserDTO;
import com.srvgeek.jobboardapi.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User registerUser(User user) {
		return userDao.save(user);
	}

	// Login (validates email/password)
	public User login(String email, String password) {
		User user = userDao.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("Invalid password");
		}

		return user;
	}

	public List<UserDTO> getAllUserDTOs() {
		return userDao.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public UserDTO getUserDTOById(Long id) {
		User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return mapToDTO(user);
	}

	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	// Mapping logic
	public UserDTO mapToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole().toString());
		return dto;
	}
}
