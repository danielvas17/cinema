package com.cinema.watch.services;

import com.cinema.watch.components.interceptors.LoggerInterceptorComponent;
import com.cinema.watch.domain.Client;
import com.cinema.watch.interfaces.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@Primary
public class ClientIntegrationService implements ClientService {

    private RestTemplate client;

    private LoggerInterceptorComponent loggerInterceptor;

    @Value("${client.host}")
    private String clientServiceUrl;

    @Autowired
    public ClientIntegrationService(LoggerInterceptorComponent loggerInterceptor) {
	this.loggerInterceptor = loggerInterceptor;
    }

    @PostConstruct
    private void init() {
	this.client = new RestTemplateBuilder()
			.rootUri(this.clientServiceUrl + "/client")
			.additionalInterceptors(loggerInterceptor)
			.build();
    }

    @Override
    public Client getClient(Long id) {
	final ResponseEntity<Client> response = this.client.getForEntity("/{id}", Client.class, id);

	return response.getBody();
    }
}
