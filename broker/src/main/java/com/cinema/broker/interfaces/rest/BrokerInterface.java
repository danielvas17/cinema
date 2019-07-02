package com.cinema.broker.interfaces.rest;

import com.cinema.broker.domain.BookingBody;
import com.cinema.broker.domain.MinutesSeenByClientBody;
import org.springframework.http.ResponseEntity;

public interface BrokerInterface {

    ResponseEntity validateBooking(BookingBody body);

    ResponseEntity getMinutesSeenByClient(MinutesSeenByClientBody body);

    ResponseEntity moviesMorePopular();

}
