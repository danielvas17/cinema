package com.cinema.movie.components;

import com.cinema.movie.entities.Movie;
import com.cinema.movie.exceptions.MovieAlreadyPublishException;
import com.cinema.movie.exceptions.MovieNotFoundException;
import com.cinema.movie.exceptions.MovieNotPublishException;
import com.cinema.movie.interfaces.components.MovieOperations;
import com.cinema.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
@Primary
public class MovieComponent implements MovieOperations {

    private MovieRepository movieRepository;

    @Autowired
    public MovieComponent(MovieRepository movieRepository) {
	this.movieRepository = movieRepository;
    }

    @Override
    public Movie createMovie(String name, int duration, int minAge) {
	final Movie movie = new Movie(name, duration, minAge);
	movieRepository.save(movie);
	return movie;
    }

    @Override
    public Movie getMovie(Long id) throws MovieNotFoundException {
	return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    @Override
    public List<Movie> getMovies() {
	return movieRepository.findAll();
    }

    @Override
    public Movie editMovie(Movie movie, Integer duration, Integer minAge) {
	if (Objects.nonNull(duration)) {
	    movie.setDuration(duration);
	}

	if (Objects.nonNull(minAge)) {
	    movie.setMinAge(minAge);
	}

	movieRepository.save(movie);
	return movie;
    }

    @Override
    public void publishMovie(Movie movie) throws MovieAlreadyPublishException {
	if (movie.isPublish())
	    throw new MovieAlreadyPublishException();

	movie.setPublish(true);

	movieRepository.save(movie);
    }

    @Override
    public void unpublishMovie(Movie movie) throws MovieNotPublishException {
	if (movie.isPublish())
	    throw new MovieNotPublishException();

	movie.setPublish(false);

	movieRepository.save(movie);
    }

    @Override
    public boolean validate(Movie movie, Date dob) {
	final boolean validateMovie = validateMovie(movie);
	final boolean validateAge = validateAge(movie, dob);

	return validateMovie && validateAge;
    }

    private boolean validateMovie(Movie movie) {
	return movie.isPublish();
    }

    private boolean validateAge(Movie movie, Date dob) {
	final int age = getAge(dob);
	return age > movie.getMinAge();
    }

    private int getAge(Date dob) {
	DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	int d1 = Integer.parseInt(formatter.format(dob));
	int d2 = Integer.parseInt(formatter.format(new Date()));
	return (d2 - d1) / 10000;
    }
}
