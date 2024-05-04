package com.developia.endproject.translateApp.service.impl;

import org.springframework.stereotype.Service;

import com.developia.endproject.translateApp.dto.CommentResponse;
import com.developia.endproject.translateApp.dto.TranslateDto;
import com.developia.endproject.translateApp.dto.TranslateResponse;
import com.developia.endproject.translateApp.entity.Translate;
import com.developia.endproject.translateApp.entity.Word;
import com.developia.endproject.translateApp.exception.OurRuntimeException;
import com.developia.endproject.translateApp.repository.TranslateRepo;
import com.developia.endproject.translateApp.service.TranslateService;
import com.developia.endproject.translateApp.service.WordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranslateServiceImpl implements TranslateService {

	private final TranslateRepo repository;
	private final WordService wordService;

	@Override
	public String translate(TranslateDto translateDto) {
		String words = translateDto.getWord();
		Word word = wordService.findByWord(words).orElseThrow(() -> new OurRuntimeException(null, "not found"));
		// response
		TranslateResponse response = new TranslateResponse();
		response.setTranslateWord(word.getTranslateWord());
		return response.getTranslateWord();
	}

	@Override
	public CommentResponse comment(TranslateDto translateDto) {
		Translate translate = new Translate();
		String translateWord = translateDto.getTranslateWord();
		Word word = wordService.findByTranslateWord(translateWord)
				.orElseThrow(() -> new OurRuntimeException(null, "not found"));
		word.setUserComment(translateDto.getComment());
		repository.save(translate);
		// response
		CommentResponse response = new CommentResponse();
		response.setComment(translateDto.getComment());
		response.setTranslateWord(word.getTranslateWord());
		return response;
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);

	}

}
