package com.cinema.movie.interfaces.rest;

import com.cinema.movie.domain.MovieEditBody;
import com.cinema.movie.domain.MovieRegisterBody;
import com.cinema.movie.exceptions.MovieAlreadyPublishException;
import com.cinema.movie.exceptions.MovieNotFoundException;
import com.cinema.movie.exceptions.MovieNotPublishException;
import org.springframework.http.ResponseEntity;

public interface MovieController {

    ResponseEntity registerMovie(MovieRegisterBody body);

    ResponseEntity publishMovie(Long id) throws MovieNotFoundException, MovieAlreadyPublishException;

    ResponseEntity getMovies();

    ResponseEntity getMovie(Long id) throws MovieNotFoundException;

    ResponseEntity editMovie(Long id, MovieEditBody body) throws MovieNotFoundException;

    ResponseEntity unpublishMovie(Long id) throws MovieNotFoundException, MovieNotPublishException;

}
