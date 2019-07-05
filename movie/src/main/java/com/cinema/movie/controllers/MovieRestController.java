package com.cinema.movie.controllers;

import com.cinema.movie.domain.*;
import com.cinema.movie.exceptions.MovieAlreadyPublishException;
import com.cinema.movie.exceptions.MovieNotFoundException;
import com.cinema.movie.exceptions.MovieNotPublishException;
import com.cinema.movie.interfaces.rest.MovieController;
import com.cinema.movie.interfaces.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/movie")
public class MovieRestController implements MovieController {

    private MovieService movieService;

    @Autowired
    public MovieRestController(MovieService movieService) {
	this.movieService = movieService;
    }

    @Override
    @PostMapping
    public ResponseEntity registerMovie(@RequestBody @Valid MovieRegisterBody body) {
	final MovieObject movieObject = movieService
			.registerMovie(body.getName(), body.getDuration(), body.getMinAge());
	return new ResponseEntity(movieObject, HttpStatus.CREATED);
    }

    @Override
    @PostMapping(path = "/{id}/actions/publish")
    public ResponseEntity publishMovie(@PathVariable("id") Long id)
		    throws MovieNotFoundException, MovieAlreadyPublishException {
	movieService.publishMovie(id);
	return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping
    public ResponseEntity getMovies() {
	final MovieList movies = movieService.getMovies();
	return new ResponseEntity(movies, HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity getMovie(@PathVariable("id") Long id) throws MovieNotFoundException {
	final MovieObject movie = movieService.getMovie(id);
	return new ResponseEntity(movie, HttpStatus.OK);
    }

    @Override
    @PatchMapping(path = "/{id}")
    public ResponseEntity editMovie(@PathVariable("id") Long id, MovieEditBody body) throws MovieNotFoundException {
	final MovieObject movieObject = movieService.editMovie(id, body.getDuration(), body.getMinAge());
	return new ResponseEntity(movieObject, HttpStatus.OK);
    }

    @Override
    @PostMapping(path = "/{id}/actions/unpublish")
    public ResponseEntity unpublishMovie(@PathVariable("id") Long id)
		    throws MovieNotFoundException, MovieNotPublishException {
	movieService.unpublishMovie(id);
	return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    @PostMapping(path = "/{id}/actions/validate")
    public ResponseEntity validateAge(@PathVariable Long id, @RequestBody ValidateBody body)
		    throws MovieNotFoundException, MovieNotPublishException {
	final boolean isValid = movieService.validate(id, body.getDob());
	return new ResponseEntity(isValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
