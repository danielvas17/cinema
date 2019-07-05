package com.cinema.broker.domain;

public class ValidateMovieResponseBody {

    private boolean isValid;

    public ValidateMovieResponseBody() {
    }

    public boolean isValid() {
	return isValid;
    }

    public void setValid(boolean valid) {
	isValid = valid;
    }
}
