package com.developia.endproject.translateApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developia.endproject.translateApp.dto.TranslateDto;
import com.developia.endproject.translateApp.service.TranslateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/translate")
@RequiredArgsConstructor
public class TranslateRest {

	private final TranslateService service;

	@PostMapping
	public ResponseEntity<Object> translate(@RequestBody TranslateDto translateDto) {
		return new ResponseEntity<Object>(service.translate(translateDto), HttpStatus.OK);
	}

	@PostMapping(path = "/comment")
	public ResponseEntity<Object> comment(@RequestBody TranslateDto translateDto) {
		return new ResponseEntity<Object>(service.comment(translateDto), HttpStatus.OK);
	}

}
