package com.cinema.movie.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Movie implements Serializable {
    private static final long serialVersionUID = -7217887244187665849L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int duration;

    @Column(name = "min_age")
    private int minAge;

    @Column(name = "is_publish")
    private boolean isPublish = false;

    public Movie() {
    }

    public Movie(String name, int duration, int minAge) {
	this.name = name;
	this.duration = duration;
	this.minAge = minAge;
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

    public boolean isPublish() {
	return isPublish;
    }

    public void setPublish(boolean publish) {
	isPublish = publish;
    }
}
