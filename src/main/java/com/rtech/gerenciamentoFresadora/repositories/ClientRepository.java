package com.rtech.gerenciamentoFresadora.repositories;

import com.rtech.gerenciamentoFresadora.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Override
    Optional<Client> findById(Long clientId);

    Client findByName(String name);
}