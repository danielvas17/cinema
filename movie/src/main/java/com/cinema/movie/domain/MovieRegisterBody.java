package com.cinema.movie.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class MovieRegisterBody {

    @NotNull
    private String name;

    @NotNull
    @Range(min = 60, max = 255)
    private int duration;

    @JsonProperty("min_age")
    private int minAge;

    public MovieRegisterBody() {
    }

    public MovieRegisterBody(String name, int duration, int minAge) {
	this.name = name;
	this.duration = duration;
	this.minAge = minAge;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getDuration() {
	return duration;
    }

    public void setDuration(int duration) {
	this.duration = duration;
    }

    public int getMinAge() {
	return minAge;
    }

    public void setMinAge(int minAge) {
	this.minAge = minAge;
    }
}
