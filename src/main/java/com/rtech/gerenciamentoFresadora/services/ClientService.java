package com.rtech.gerenciamentoFresadora.services;

import com.rtech.gerenciamentoFresadora.entities.Client;
import com.rtech.gerenciamentoFresadora.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    //LIST ALL CLIENTS
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    //GET CLIENT BY ID
    public Optional<Client> findClientById(Long clientId){
        return clientRepository.findById(clientId);
    }

    //GET CLIENT BY NAME
    public Client findClientByName(String name){
        return clientRepository.findByName(name);
    }

    //CREATE CLIENT
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    //UPDATE CLIENT
    public Client updateClient(Long clientId, Client clientDetails){
        Client client = clientRepository.findById(clientId).get();
        client.setName(clientDetails.getName());
        client.setPhoneNumber(clientDetails.getPhoneNumber());
        return clientRepository.save(client);
    }

    //DELETE CLIENT
    public void deleteClient(Long clientId){
        clientRepository.deleteById(clientId);
    }
}
