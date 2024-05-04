package com.developia.endproject.translateApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developia.endproject.translateApp.dto.UserDto;
import com.developia.endproject.translateApp.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserRest {

	private final UserService service;

	@PostMapping(path = "/signup")
	public ResponseEntity<Object> signUp(@Valid @RequestBody UserDto userDto, BindingResult br) {
		return new ResponseEntity<>(service.signUp(userDto, br), HttpStatus.CREATED);
	}

	@GetMapping(path = "/login")
	public String login() {

		return "Hesaba daxil olundu";
	}
}
