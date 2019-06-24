package com.cinema.client.interfaces.rest;

import com.cinema.client.domain.ClientRegisterBody;
import com.cinema.client.domain.EditClientBody;
import com.cinema.client.exceptions.ClientAlreadyRegisteredException;
import com.cinema.client.exceptions.ClientNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ClientController {

    ResponseEntity registerClient(ClientRegisterBody body) throws ClientAlreadyRegisteredException;

    ResponseEntity getClients();

    ResponseEntity getClient(Long id) throws ClientNotFoundException;

    ResponseEntity editClient(Long id, EditClientBody body) throws ClientNotFoundException;

    ResponseEntity deleteClient(Long id);

}
