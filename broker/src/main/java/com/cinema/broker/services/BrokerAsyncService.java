package com.cinema.broker.services;

import com.cinema.broker.domain.MinutesSeenByClientResponse;
import com.cinema.broker.domain.MovieList;
import com.cinema.broker.interfaces.services.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Primary
public class BrokerAsyncService implements BrokerService {

    private ClientService clientService;

    private MovieService movieService;

    @Autowired
    public BrokerAsyncService(ClientService clientService, MovieService movieService) {
	this.clientService = clientService;
	this.movieService = movieService;
    }

    @Override
    public boolean validateBooking(Long clientId, Long movieId) throws ExecutionException, InterruptedException {
	final CompletableFuture<Boolean> validateClient = clientService.validateClient(clientId);
	final CompletableFuture<Boolean> validateMovie = movieService.validateMovie(movieId);

	CompletableFuture.allOf(validateClient, validateMovie).join();

	return validateClient.get() && validateMovie.get();
    }

    @Override
    public MinutesSeenByClientResponse getMinutesSeenByClient(Long clientId) {
	return null;
    }

    @Override
    public MovieList moviesMorePopular() {
	return null;
    }
}
