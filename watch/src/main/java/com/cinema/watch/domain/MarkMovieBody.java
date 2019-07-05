package com.cinema.watch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class MarkMovieBody {

    @NotNull
    @JsonProperty("movie")
    private Long movieId;

    @NotNull
    @JsonProperty("client")
    private Long clientId;

    public MarkMovieBody() {
    }

    public Long getMovieId() {
	return movieId;
    }

    public void setMovieId(Long movieId) {
	this.movieId = movieId;
    }

    public Long getClientId() {
	return clientId;
    }

    public void setClientId(Long clientId) {
	this.clientId = clientId;
    }
}
