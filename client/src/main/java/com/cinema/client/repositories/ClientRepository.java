package com.cinema.client.repositories;

import com.cinema.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsClientByIdentificationEquals(String identification);
}
