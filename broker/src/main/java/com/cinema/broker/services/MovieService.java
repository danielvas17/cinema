package com.cinema.broker.services;

import com.cinema.broker.domain.MovieList;
import com.cinema.broker.domain.MovieObject;
import com.cinema.broker.domain.ValidateMovieBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
public class MovieService {

    private static final String MOVIE = "/movie";

    private final RestTemplate client;

    @Value("${movie.host}")
    private String movieServiceHost;

    public MovieService() {
	this.client = new RestTemplateBuilder()
			.rootUri(movieServiceHost + MOVIE)
			//.additionalInterceptors(new MailchimpRequestResponseLoggingInterceptor())
			//.errorHandler(new MailchimpErrorHandler())
			.build();
    }

    @Async
    public CompletableFuture<Boolean> validateMovie(Long id, Date dob) {
	ValidateMovieBody body = new ValidateMovieBody(dob);

	final ResponseEntity<MovieObject> movieEntity = this.client
			.postForEntity("/{id}/validate-subscription", body, MovieObject.class, id);
	return CompletableFuture.completedFuture(movieEntity.getStatusCode() == HttpStatus.OK);
    }

    @Async
    public CompletableFuture<MovieList> getMorePopular() {
	final ResponseEntity<MovieList> moviesEntity = this.client.getForEntity("/report/popular", MovieList.class);
	return CompletableFuture.completedFuture(moviesEntity.getBody());
    }
}
