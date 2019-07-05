package com.cinema.watch.interfaces.rest;

import com.cinema.watch.domain.MarkMovieBody;
import com.cinema.watch.exceptions.NotValidMovieException;
import org.springframework.http.ResponseEntity;

public interface WatchService {

    ResponseEntity markMovie(MarkMovieBody body) throws NotValidMovieException;

}
