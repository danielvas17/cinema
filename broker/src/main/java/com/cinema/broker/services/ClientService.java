package com.cinema.broker.services;

import com.cinema.broker.domain.ClientObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ClientService {

    private static final String CLIENT = "/client";

    private final RestTemplate client;

    @Value("${client.host}")
    private String clientServiceHost;

    public ClientService() {
	this.client = new RestTemplateBuilder()
			.rootUri(clientServiceHost + CLIENT)
			//.additionalInterceptors(new MailchimpRequestResponseLoggingInterceptor())
			//.errorHandler(new MailchimpErrorHandler())
			.build();
    }

    @Async
    public CompletableFuture<Boolean> validateClient(Long id) {
	final ResponseEntity<ClientObject> clientEntity = this.client.getForEntity("/{id}", ClientObject.class, id);
	return CompletableFuture.completedFuture(clientEntity.getStatusCode() == HttpStatus.OK);
    }

}
