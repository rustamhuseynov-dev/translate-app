package com.developia.endproject.translateApp.exception;

import org.springframework.validation.BindingResult;

import lombok.Getter;

@Getter
public class OurRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BindingResult br;

	public OurRuntimeException(BindingResult br, String m) {
		super(m);
		this.br = br;
	}

}
