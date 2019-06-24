package com.cinema.client.domain;

import java.util.HashMap;
import java.util.Map;

public class ApiError {

    private Map<String, Object> errors;

    public ApiError() {
    }

    public ApiError(String field, String error) {
	this.errors = new HashMap<>();
	this.errors.put(field, error);
    }

    public ApiError(Map<String, Object> errors) {
	this.errors = errors;
    }

    public Map<String, Object> getErrors() {
	return errors;
    }

    public void setErrors(Map<String, Object> errors) {
	this.errors = errors;
    }
}
