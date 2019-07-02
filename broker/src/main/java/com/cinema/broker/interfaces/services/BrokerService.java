package com.cinema.broker.interfaces.services;

import com.cinema.broker.domain.MinutesSeenByClientResponse;
import com.cinema.broker.domain.MovieList;

import java.util.concurrent.ExecutionException;

public interface BrokerService {

    boolean validateBooking(Long clientId, Long movieId) throws ExecutionException, InterruptedException;

    MinutesSeenByClientResponse getMinutesSeenByClient(Long clientId);

    MovieList moviesMorePopular();

}
