package com.cinema.movie.controllers;

import com.cinema.movie.domain.ApiError;
import com.cinema.movie.exceptions.MovieAlreadyPublishException;
import com.cinema.movie.exceptions.MovieNotFoundException;
import com.cinema.movie.exceptions.MovieNotPublishException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class MovieExceptionHandler {
    @ExceptionHandler({
		    MovieAlreadyPublishException.class,
		    MovieNotPublishException.class,
		    MovieNotFoundException.class,
    })
    public final ResponseEntity<ApiError> clientExceptionHandler(Exception exception, WebRequest request) {
	HttpHeaders headers = new HttpHeaders();

	if (exception instanceof MovieAlreadyPublishException || exception instanceof MovieNotPublishException) {
	    return handleExceptionInternal(exception, new ApiError("Error", "Movie invalid operation"), headers,
			    HttpStatus.BAD_REQUEST, request);
	} else if (exception instanceof MovieNotFoundException) {
	    return handleExceptionInternal(exception, null, headers, HttpStatus.NOT_FOUND, request);
	} else {
	    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	    return handleExceptionInternal(exception, null, headers, status, request);
	}
    }

    private ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers,
		    HttpStatus status, WebRequest request) {
	if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
	    request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
	}

	return new ResponseEntity<>(body, headers, status);
    }
}
