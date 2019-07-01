package com.cinema.movie.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieEditBody {

    private int duration;

    @JsonProperty("min_age")
    private int minAge;

    public MovieEditBody() {
    }

    public MovieEditBody(int duration, int minAge) {
	this.duration = duration;
	this.minAge = minAge;
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
