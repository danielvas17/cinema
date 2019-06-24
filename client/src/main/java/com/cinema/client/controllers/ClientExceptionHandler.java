package com.cinema.client.controllers;

import com.cinema.client.domain.ApiError;
import com.cinema.client.exceptions.CinemaException;
import com.cinema.client.exceptions.ClientAlreadyRegisteredException;
import com.cinema.client.exceptions.ClientNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class ClientExceptionHandler {
    @ExceptionHandler({
		    CinemaException.class,
    })
    public final ResponseEntity<ApiError> clientExceptionHandler(Exception exception, WebRequest request) {
	HttpHeaders headers = new HttpHeaders();

	if (exception instanceof ClientAlreadyRegisteredException) {
	    return handleExceptionInternal(exception, new ApiError("Error", "Client already registered"), headers,
			    HttpStatus.BAD_REQUEST, request);
	} else if (exception instanceof ClientNotFoundException) {
	    return handleExceptionInternal(exception, null, headers, HttpStatus.NOT_FOUND, request);
	} else {
	    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	    return handleExceptionInternal(exception, null, headers, status, request);
	}
    }

    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers,
		    HttpStatus status, WebRequest request) {
	if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
	    request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
	}

	return new ResponseEntity<>(body, headers, status);
    }
}
