package com.cinema.broker.controllers;

import com.cinema.broker.domain.BookingBody;
import com.cinema.broker.domain.MinutesSeenByClientBody;
import com.cinema.broker.interfaces.rest.BrokerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/broker")
public class BrokerRestController implements BrokerInterface {

    @Override
    public ResponseEntity validateBooking(BookingBody body) {

	return null;
    }

    @Override
    public ResponseEntity getMinutesSeenByClient(MinutesSeenByClientBody body) {
	return null;
    }

    @Override
    public ResponseEntity moviesMorePopular() {
	return null;
    }
}
