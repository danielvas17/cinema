package com.cinema.movie.interfaces.services;

import com.cinema.movie.domain.MovieList;
import com.cinema.movie.domain.MovieObject;
import com.cinema.movie.exceptions.MovieAlreadyPublishException;
import com.cinema.movie.exceptions.MovieNotFoundException;
import com.cinema.movie.exceptions.MovieNotPublishException;

import java.util.Date;

public interface MovieService {

    MovieObject registerMovie(String name, int duration, int minAge);

    void publishMovie(Long id) throws MovieNotFoundException, MovieAlreadyPublishException;

    MovieList getMovies();

    MovieObject getMovie(Long id) throws MovieNotFoundException;

    MovieObject editMovie(Long id, int duration, int minAge) throws MovieNotFoundException;

    void unpublishMovie(Long id) throws MovieNotFoundException, MovieNotPublishException;

    boolean validate(Long id, Date dob) throws MovieNotFoundException, MovieNotPublishException;

}
