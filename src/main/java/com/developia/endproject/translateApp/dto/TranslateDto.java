package com.developia.endproject.translateApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TranslateDto {

	private String comment;
	@NotEmpty
	private String language;
	private String word;
	private String translateWord;

}
