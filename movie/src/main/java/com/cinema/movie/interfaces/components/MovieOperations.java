package com.cinema.movie.interfaces.components;

import com.cinema.movie.entities.Movie;
import com.cinema.movie.exceptions.MovieAlreadyPublishException;
import com.cinema.movie.exceptions.MovieNotFoundException;
import com.cinema.movie.exceptions.MovieNotPublishException;

import java.util.List;

public interface MovieOperations {

    Movie createMovie(String name, int duration, int minAge);

    Movie getMovie(Long id) throws MovieNotFoundException;

    List<Movie> getMovies();

    Movie editMovie(Movie movie, Integer duration, Integer minAge) throws MovieNotFoundException;

    void publishMovie(Movie movie) throws MovieAlreadyPublishException;

    void unpublishMovie(Movie movie) throws MovieNotPublishException;
}
