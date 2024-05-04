package com.developia.endproject.translateApp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper obj = new ModelMapper();
		return obj;
	}
}
