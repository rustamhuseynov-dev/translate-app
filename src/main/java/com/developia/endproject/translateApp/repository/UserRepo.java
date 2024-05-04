package com.developia.endproject.translateApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developia.endproject.translateApp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	User username(String findByUsername);

}
