package com.movieApp.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Movie ID already exists, exception handled by Custom exception")
public class DuplicateMovieIdExceptions extends Exception {
	

}
