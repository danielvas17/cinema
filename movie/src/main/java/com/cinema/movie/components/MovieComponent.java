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
}
