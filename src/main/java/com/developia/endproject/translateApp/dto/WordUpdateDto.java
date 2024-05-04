package com.developia.endproject.translateApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WordUpdateDto {

	private Integer id;
	@NotEmpty(message = "boş qoymaq olmaz!")
	private String translateWord;
}
