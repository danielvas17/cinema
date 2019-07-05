package com.cinema.watch.components;

import com.cinema.watch.entities.ClientWatch;
import com.cinema.watch.interfaces.component.ClientWatchComponent;
import com.cinema.watch.repositories.ClientWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ClientWatchOperation implements ClientWatchComponent {

    private ClientWatchRepository clientWatchRepository;

    @Autowired
    public ClientWatchOperation(ClientWatchRepository clientWatchRepository) {
	this.clientWatchRepository = clientWatchRepository;
    }

    @Override
    public void markMovie(Long clientId, Long movieId) {
	ClientWatch clientWatch = new ClientWatch(movieId, clientId);

	clientWatchRepository.save(clientWatch);
    }
}
