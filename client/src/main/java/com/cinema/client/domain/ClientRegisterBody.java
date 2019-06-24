package com.cinema.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClientRegisterBody {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("identification")
    private String identification;

    @JsonProperty("date_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    public ClientRegisterBody() {
    }

    public ClientRegisterBody(String firstName, String lastName, Date dob) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getIdentification() {
	return identification;
    }

    public void setIdentification(String identification) {
	this.identification = identification;
    }

    public Date getDob() {
	return dob;
    }

    public void setDob(Date dob) {
	this.dob = dob;
    }
}
