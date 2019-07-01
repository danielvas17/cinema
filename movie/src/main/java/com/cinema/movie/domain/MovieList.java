package com.cinema.movie.domain;

import java.util.List;

public class MovieList {

    private List<MovieObject> movies;

    public MovieList() {
    }

    public MovieList(List<MovieObject> movies) {
	this.movies = movies;
    }

    public List<MovieObject> getMovies() {
	return movies;
    }

    public void setMovies(List<MovieObject> movies) {
	this.movies = movies;
    }
}
