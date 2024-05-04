package com.developia.endproject.translateApp.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.UserDto;
import com.developia.endproject.translateApp.entity.Authority;
import com.developia.endproject.translateApp.entity.User;
import com.developia.endproject.translateApp.exception.OurRuntimeException;
import com.developia.endproject.translateApp.repository.UserRepo;
import com.developia.endproject.translateApp.service.AuthorityService;
import com.developia.endproject.translateApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepo repository;
	private final AuthorityService authorityService;
	private final ModelMapper mapper;

	// logic codes
	@Override
	public UserDto signUp(UserDto userDto, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, null);
		}
		Optional<User> check = repository.findByUsername(userDto.getUsername());
		if (check.isPresent()) {
			throw new OurRuntimeException(null, "bele bir username istifade olunub");
		}

		User user = new User();
		mapper.map(userDto, user);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass = userDto.getPassword();
		String raw = passwordEncoder.encode(pass);
		user.setPassword(raw);
		user.setEnabled(1);
		repository.save(user);
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUsername(userDto.getUsername());
		authorityService.add(authority);
		// response
		UserDto dto = new UserDto();
		mapper.map(user, dto);
		return dto;
	}

	@Override
	public void add(User user) {
		repository.save(user);

	}

	@Override
	public Optional<User> findById(Integer id) {
		Optional<User> optional = repository.findById(id);
		return optional;
	}

	@Override
	public User username(String findByUsername) {
		User user = repository.username(findByUsername);
		if (user == null) {
			throw new OurRuntimeException(null, "bele bir user yoxdur");
		}
		return user;
	}

}
