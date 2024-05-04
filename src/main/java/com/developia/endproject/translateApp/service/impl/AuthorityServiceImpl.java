package com.developia.endproject.translateApp.service.impl;

import org.springframework.stereotype.Service;

import com.developia.endproject.translateApp.entity.Authority;
import com.developia.endproject.translateApp.repository.AuthorityRepo;
import com.developia.endproject.translateApp.service.AuthorityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

	private final AuthorityRepo repository;

	@Override
	public void add(Authority authority) {
		repository.save(authority);

	}

}
