package com.cinema.client.controllers;

import com.cinema.client.domain.ClientList;
import com.cinema.client.domain.ClientRegisterBody;
import com.cinema.client.domain.EditClientBody;
import com.cinema.client.entities.Client;
import com.cinema.client.exceptions.ClientAlreadyRegisteredException;
import com.cinema.client.exceptions.ClientNotFoundException;
import com.cinema.client.interfaces.rest.ClientController;
import com.cinema.client.interfaces.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/client")
public class ClientRestController implements ClientController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
	this.clientService = clientService;
    }

    @Override
    @PostMapping
    public ResponseEntity registerClient(@RequestBody @Valid ClientRegisterBody body)
		    throws ClientAlreadyRegisteredException {
	final Client client = clientService
			.createClient(body.getFirstName(), body.getLastName(), body.getIdentification(), body.getDob());
	return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity getClients() {
	final ClientList clients = clientService.getClients();
	return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity getClient(@PathVariable Long id) throws ClientNotFoundException {
	final Client client = clientService.getClient(id);
	return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @Override
    public ResponseEntity editClient(Long id, EditClientBody body) throws ClientNotFoundException {
	final Client client = clientService.editClient(id, body.getFirstName(), body.getLastName());
	return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteClient(Long id) {
	// TODO
	return null;
    }

}
