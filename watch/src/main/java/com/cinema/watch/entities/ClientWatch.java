package com.cinema.watch.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "client_watch")
public class ClientWatch implements Serializable {

    private static final long serialVersionUID = -3667540520806877954L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "client_id")
    private Long clientId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "watch_datetime")
    private Date datetime;

    public ClientWatch() {
	super();
    }

    public ClientWatch(Long movieId, Long clientId) {
	this.movieId = movieId;
	this.clientId = clientId;
	this.datetime = new Date();
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	ClientWatch that = (ClientWatch) o;
	return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    public Long getId() {
	return id;
    }

    public Long getMovieId() {
	return movieId;
    }

    public Long getClientId() {
	return clientId;
    }

    public Date getDatetime() {
	return datetime;
    }
}
