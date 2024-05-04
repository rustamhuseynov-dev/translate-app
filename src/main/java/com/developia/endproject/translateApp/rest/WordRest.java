package com.developia.endproject.translateApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.dto.WordUpdateDto;
import com.developia.endproject.translateApp.service.WordService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "word")
@RequiredArgsConstructor
public class WordRest {

	private final WordService service;

	@PostMapping
	public ResponseEntity<Object> addWord(@Valid @RequestBody WordDto wordDto, BindingResult br) {
		return new ResponseEntity<Object>(service.addWord(wordDto, br), HttpStatus.OK);
	}

	@GetMapping(path = "/pagination/begin/{begin}/length/{length}")
	public ResponseEntity<Object> pagination(@PathVariable Integer begin, @PathVariable Integer length) {
		return new ResponseEntity<Object>(service.findAllWordPagination(begin, length), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Object> updateWord(@Valid @RequestBody WordUpdateDto wordUpdateDto, BindingResult br) {
		return new ResponseEntity<Object>(service.updateWord(wordUpdateDto, br), HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Object> deleteWord(@PathVariable Integer id) {
		return new ResponseEntity<Object>(service.deleteWord(id), HttpStatus.OK);
	}

}
