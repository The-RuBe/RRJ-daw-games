package com.daw.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JuegoNotFoundException extends RuntimeException {

	public JuegoNotFoundException(String message) {
        super(message);
    }
	
	private static final long serialVersionUID = 6040687907736977109L;
}