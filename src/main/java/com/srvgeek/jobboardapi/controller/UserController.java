package com.srvgeek.jobboardapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srvgeek.jobboardapi.dto.UserDTO;
import com.srvgeek.jobboardapi.entity.User;
import com.srvgeek.jobboardapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}

	@PostMapping("/login")
	public UserDTO loginUser(@RequestBody Map<String, String> loginData) {
		String email = loginData.get("email");
		String password = loginData.get("password");

		return userService.mapToDTO(userService.login(email, password));
	}

	@GetMapping
	public List<UserDTO> getAllUsers() {
		return userService.getAllUserDTOs();
	}

	@GetMapping("/{id}")
	public UserDTO getUser(@PathVariable Long id) {
		return userService.getUserDTOById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "User deleted successfully";
	}
}
