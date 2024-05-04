package com.developia.endproject.translateApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developia.endproject.translateApp.dto.AdminDto;
import com.developia.endproject.translateApp.dto.SelectAdminDto;
import com.developia.endproject.translateApp.service.AdminService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/admin")
@RequiredArgsConstructor
public class AdminRest {

	private final AdminService service;

	@PostMapping(path = "/signup")
	@PreAuthorize(value = "hasAuthority('ROLE_NEXT_ADMIN')")
	public ResponseEntity<Object> singUp(@Valid @RequestBody AdminDto adminDto, BindingResult br) {
		return new ResponseEntity<Object>(service.signUp(adminDto, br), HttpStatus.CREATED);
	}

	@PostMapping(path = "/select")
	@PreAuthorize(value = "hasAuthority('ROLE_ADMİN')")
	public ResponseEntity<Object> selectAdmin(@RequestBody SelectAdminDto selectAdminDto) {
		System.out.println(selectAdminDto.getId());
		return new ResponseEntity<Object>(service.selectAdmin(selectAdminDto), HttpStatus.OK);
	}
}
