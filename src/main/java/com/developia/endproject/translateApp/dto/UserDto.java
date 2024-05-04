package com.developia.endproject.translateApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Size(min = 2, message = "minumum 2 herf olmalidi.")
	@Size(max = 20, message = "maximum 20 herf olmalidi.")
	private String username;
	@NotEmpty
	private String password;
}
