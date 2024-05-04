package com.developia.endproject.translateApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developia.endproject.translateApp.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByUsername(String username);

}
