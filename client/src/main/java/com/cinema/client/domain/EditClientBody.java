package com.cinema.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditClientBody {

    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String lastName;

    public EditClientBody() {
    }

    public EditClientBody(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
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
}
