package com.cinema.watch.interfaces.service;

import com.cinema.watch.exceptions.NotValidMovieException;

public interface ClientWatchService {

    void markMovie(Long movieId, Long clientId) throws NotValidMovieException;

}
