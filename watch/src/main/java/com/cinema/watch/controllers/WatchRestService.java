package com.cinema.watch.controllers;

import com.cinema.watch.domain.MarkMovieBody;
import com.cinema.watch.exceptions.NotValidMovieException;
import com.cinema.watch.interfaces.rest.WatchService;
import com.cinema.watch.interfaces.service.ClientWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/watch")
public class WatchRestService implements WatchService {

    private ClientWatchService clientWatchService;

    @Autowired
    public WatchRestService(ClientWatchService clientWatchService) {
	this.clientWatchService = clientWatchService;
    }

    @Override
    @PostMapping
    public ResponseEntity markMovie(@RequestBody MarkMovieBody body) throws NotValidMovieException {
	clientWatchService.markMovie(body.getMovieId(), body.getClientId());

	return new ResponseEntity(HttpStatus.OK);
    }
}
