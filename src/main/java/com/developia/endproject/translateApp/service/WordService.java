package com.developia.endproject.translateApp.service;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.WordDto;
import com.developia.endproject.translateApp.dto.WordResponse;
import com.developia.endproject.translateApp.dto.WordUpdateDto;
import com.developia.endproject.translateApp.entity.Word;

import jakarta.validation.Valid;

public interface WordService {

	WordDto addWord(WordDto wordDto, BindingResult br);

	Optional<Word> findByWord(String word);

	Optional<Word> findByTranslateWord(String translateWord);

	WordResponse findAllWordPagination(Integer begin, Integer length);

	WordUpdateDto updateWord(@Valid WordUpdateDto wordUpdateDto, BindingResult br);

	String deleteWord(Integer id);

}
