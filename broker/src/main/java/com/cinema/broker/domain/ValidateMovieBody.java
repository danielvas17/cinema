package com.cinema.broker.domain;

import java.util.Date;

public class ValidateMovieBody {

    private Date dob;

    public ValidateMovieBody() {
    }

    public ValidateMovieBody(Date dob) {
	this.dob = dob;
    }

    public Date getDob() {
	return dob;
    }

    public void setDob(Date dob) {
	this.dob = dob;
    }
}
