package com.developia.endproject.translateApp.service;

import com.developia.endproject.translateApp.dto.CommentResponse;
import com.developia.endproject.translateApp.dto.TranslateDto;

public interface TranslateService {

	String translate(TranslateDto translateDto);

	CommentResponse comment(TranslateDto translateDto);

	void deleteById(Integer id);

}
