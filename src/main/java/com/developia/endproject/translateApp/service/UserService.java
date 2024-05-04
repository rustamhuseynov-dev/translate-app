package com.developia.endproject.translateApp.service;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.UserDto;
import com.developia.endproject.translateApp.entity.User;

public interface UserService {

	UserDto signUp(UserDto userDto, BindingResult br);

	void add(User user);

	Optional<User> findById(Integer id);

	User username(String findByUsername);

}
