package com.developia.endproject.translateApp.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.AdminDto;
import com.developia.endproject.translateApp.dto.SelectAdminDto;
import com.developia.endproject.translateApp.entity.Admin;
import com.developia.endproject.translateApp.entity.Authority;
import com.developia.endproject.translateApp.entity.User;
import com.developia.endproject.translateApp.exception.OurRuntimeException;
import com.developia.endproject.translateApp.repository.AdminRepo;
import com.developia.endproject.translateApp.service.AdminService;
import com.developia.endproject.translateApp.service.AuthorityService;
import com.developia.endproject.translateApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final AdminRepo repository;
	private final UserService userService;
	private final AuthorityService authorityService;
	private final ModelMapper mapper;

	@Override
	public AdminDto signUp(AdminDto adminDto, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, null);
		}

		Optional<Admin> optional = repository.findByUsername(adminDto.getUsername());
		if (optional.isPresent()) {
			throw new OurRuntimeException(null, "bu username istifade olunub");
		}

		Admin admin = new Admin();
		mapper.map(adminDto, admin);
		repository.save(admin);
		Authority authority = new Authority();
		authority.setAuthority("ROLE_ADMIN");
		authority.setUsername(adminDto.getUsername());
		authorityService.add(authority);
		User user = new User();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = adminDto.getPassword();
		String raw = encoder.encode(pass);
		user.setUsername(adminDto.getUsername());
		user.setPassword(raw);
		userService.add(user);
		// response
		AdminDto dto = new AdminDto();
		mapper.map(admin, dto);
		return dto;
	}

	@Override
	public AdminDto selectAdmin(SelectAdminDto selectAdminDto) {
		Integer id = selectAdminDto.getId();
		User user = userService.findById(id)
				.orElseThrow(() -> new OurRuntimeException(null, "bele bir user tapilmadi"));
		Authority authority = new Authority();
		authority.setUsername(user.getUsername());
		authority.setAuthority("ROLE_NEXT_ADMIN");
		authorityService.add(authority);
		return null;
	}
}
