package com.cinema.client.interfaces.services;

import com.cinema.client.domain.ClientList;
import com.cinema.client.entities.Client;
import com.cinema.client.exceptions.ClientAlreadyRegisteredException;
import com.cinema.client.exceptions.ClientNotFoundException;

import java.util.Date;

public interface ClientService {

    Client createClient(String firstName, String lastName, String identification, Date dob)
		    throws ClientAlreadyRegisteredException;

    ClientList getClients();

    Client getClient(Long id) throws ClientNotFoundException;

    Client editClient(Long id, String firstName, String lastName) throws ClientNotFoundException;

    void deleteClient(Long id);

}
