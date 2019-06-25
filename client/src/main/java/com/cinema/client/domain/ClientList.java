package com.cinema.client.domain;

import com.cinema.client.entities.Client;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ClientList {

    @JsonProperty("clients")
    private List<Client> clientList;

    public ClientList() {
    }

    public ClientList(List<Client> clientList) {
	this.clientList = clientList;
    }

    public List<Client> getClientList() {
	return clientList;
    }

    public void setClientList(List<Client> clientList) {
	this.clientList = clientList;
    }
}
