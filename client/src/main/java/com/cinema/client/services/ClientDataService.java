package com.cinema.client.services;

import com.cinema.client.domain.ClientList;
import com.cinema.client.entities.Client;
import com.cinema.client.exceptions.ClientAlreadyRegisteredException;
import com.cinema.client.exceptions.ClientNotFoundException;
import com.cinema.client.interfaces.services.ClientService;
import com.cinema.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Primary
public class ClientDataService implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientDataService(ClientRepository clientRepository) {
	this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(String firstName, String lastName, String identification, Date dob)
		    throws ClientAlreadyRegisteredException {
	validateClient(identification);

	Client client = new Client(firstName, lastName, identification, dob);
	clientRepository.save(client);

	return client;
    }

    @Override
    public ClientList getClients() {
	final List<Client> clients = clientRepository.findAll();
	return new ClientList(clients);
    }

    @Override
    public Client getClient(Long id) throws ClientNotFoundException {
	return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Client editClient(Long id, String firstName, String lastName) throws ClientNotFoundException {
	final Client client = getClient(id);

	if (Objects.nonNull(firstName) || !firstName.isEmpty()) {
	    client.setFirstName(firstName);
	}

	if (Objects.nonNull(lastName) || !lastName.isEmpty()) {
	    client.setLastName(lastName);
	}

	clientRepository.save(client);

	return client;
    }

    @Override
    public void deleteClient(Long id) {

    }

    private void validateClient(String identification) throws ClientAlreadyRegisteredException {
	if (clientRepository.existsClientByIdentificationEquals(identification)) {
	    throw new ClientAlreadyRegisteredException();
	}
    }
}
