package com.cinema.movie.services;

import com.cinema.movie.domain.MovieList;
import com.cinema.movie.domain.MovieObject;
import com.cinema.movie.entities.Movie;
import com.cinema.movie.exceptions.MovieAlreadyPublishException;
import com.cinema.movie.exceptions.MovieNotFoundException;
import com.cinema.movie.exceptions.MovieNotPublishException;
import com.cinema.movie.interfaces.components.MovieOperations;
import com.cinema.movie.interfaces.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class MovieDataService implements MovieService {

    private MovieOperations movieOperations;

    @Autowired
    public MovieDataService(MovieOperations movieOperations) {
	this.movieOperations = movieOperations;
    }

    @Override
    public MovieObject registerMovie(String name, int duration, int minAge) {
	final Movie movie = movieOperations.createMovie(name, duration, minAge);
	return movieToObject(movie);
    }

    @Override
    public void publishMovie(Long id) throws MovieNotFoundException, MovieAlreadyPublishException {
	final Movie movie = movieOperations.getMovie(id);
	movieOperations.publishMovie(movie);
    }

    @Override
    public MovieList getMovies() {
	final List<MovieObject> movieObjectList = movieOperations.getMovies().stream().map(this::movieToObject)
			.collect(Collectors.toList());
	return new MovieList(movieObjectList);
    }

    @Override
    public MovieObject getMovie(Long id) throws MovieNotFoundException {
	final Movie movie = movieOperations.getMovie(id);
	return movieToObject(movie);
    }

    @Override
    public MovieObject editMovie(Long id, int duration, int minAge) throws MovieNotFoundException {
	Movie movie = movieOperations.getMovie(id);
	movie = movieOperations.editMovie(movie, duration, minAge);
	return movieToObject(movie);
    }

    @Override
    public void unpublishMovie(Long id) throws MovieNotFoundException, MovieNotPublishException {
	final Movie movie = movieOperations.getMovie(id);
	movieOperations.unpublishMovie(movie);
    }

    @Override
    public boolean validate(Long id, Date dob) throws MovieNotFoundException, MovieNotPublishException {
	final Movie movie = movieOperations.getMovie(id);
	return movieOperations.validate(movie, dob);
    }

    private MovieObject movieToObject(Movie movie) {
	MovieObject movieObject = new MovieObject();
	movieObject.setId(movie.getId());
	movieObject.setName(movie.getName());
	movieObject.setDuration(movie.getDuration());
	movieObject.setMinAge(movie.getMinAge());

	return movieObject;
    }

}
