package com.cinema.watch.services;

import com.cinema.watch.components.interceptors.LoggerInterceptorComponent;
import com.cinema.watch.domain.ValidateMovieBody;
import com.cinema.watch.interfaces.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
@Primary
public class MovieIntegrationService implements MovieService {

    private RestTemplate client;

    private LoggerInterceptorComponent loggerInterceptor;

    @Value("${movie.host}")
    private String movieServiceUrl;

    @Autowired
    public MovieIntegrationService(LoggerInterceptorComponent loggerInterceptor) {
	this.loggerInterceptor = loggerInterceptor;
    }

    @PostConstruct
    private void init() {
	this.client = new RestTemplateBuilder()
			.rootUri(this.movieServiceUrl + "/movie")
			.additionalInterceptors(loggerInterceptor)
			.build();
    }

    @Override
    public boolean validateMovie(Long id, Date dob) {
	ValidateMovieBody body = new ValidateMovieBody(dob);
	final ResponseEntity<Object> response = this.client
			.postForEntity("/{id}/actions/validate", body, Object.class, id);
	return response.getStatusCode().is2xxSuccessful();
    }
}
