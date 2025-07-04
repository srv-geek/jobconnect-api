package com.srvgeek.jobboardapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srvgeek.jobboardapi.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email); // for login

}
