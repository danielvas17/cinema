package com.cinema.watch.repositories;

import com.cinema.watch.entities.ClientWatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientWatchRepository extends JpaRepository<ClientWatch, Long> {
}
