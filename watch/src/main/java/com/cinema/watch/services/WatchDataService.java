package com.cinema.watch.services;

import com.cinema.watch.domain.Client;
import com.cinema.watch.exceptions.NotValidMovieException;
import com.cinema.watch.interfaces.component.ClientWatchComponent;
import com.cinema.watch.interfaces.service.ClientService;
import com.cinema.watch.interfaces.service.ClientWatchService;
import com.cinema.watch.interfaces.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class WatchDataService implements ClientWatchService {

    private ClientService clientService;

    private MovieService movieService;

    private ClientWatchComponent clientWatchComponent;

    @Autowired
    public WatchDataService(ClientService clientService, MovieService movieService,
		    ClientWatchComponent clientWatchComponent) {
	this.clientService = clientService;
	this.movieService = movieService;
	this.clientWatchComponent = clientWatchComponent;
    }

    @Override
    public void markMovie(Long movieId, Long clientId) throws NotValidMovieException {
	final Client client = clientService.getClient(clientId);
	final boolean isValid = movieService.validateMovie(movieId, client.getDob());

	if (!isValid) {
	    throw new NotValidMovieException();
	}

	clientWatchComponent.markMovie(clientId, movieId);
    }
}
