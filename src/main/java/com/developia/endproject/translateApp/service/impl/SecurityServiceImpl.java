package com.developia.endproject.translateApp.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.developia.endproject.translateApp.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Override
	public String findByUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return username;
	}

}
