package com.cinema.movie.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieObject {

    private Long id;

    private String name;

    private int duration;

    @JsonProperty("min_age")
    private int minAge;

    public MovieObject() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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
