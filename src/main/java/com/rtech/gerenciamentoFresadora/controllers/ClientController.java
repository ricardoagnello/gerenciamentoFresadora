package com.rtech.gerenciamentoFresadora.controllers;

import com.rtech.gerenciamentoFresadora.entities.Client;

import com.rtech.gerenciamentoFresadora.exceptionhandler.ClientNotFoundException;

import com.rtech.gerenciamentoFresadora.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    //LIST USERS
    @GetMapping("/clients")
    public List<Client> getUsers() {
        return clientService.findAll();
    }

    //CLIENT BY ID
    @GetMapping("/clients/{clientId}")
    public Client getClientById(@PathVariable Long clientId) {
        return clientService.findClientById(clientId).orElseThrow(() -> new ClientNotFoundException());
    }

    //CLIENT BY NAME
    @GetMapping("/clients/{name}")
    public Client getClientById(@PathVariable String name) {
        return clientService.findClientByName(name);
    }

    //CREATE CLIENT
    @PostMapping("/clients/createClient")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }

    //UPDATE USER
    @PutMapping("/updateClient/{clientId}")
    public Client updateClient(@PathVariable Long clientId, @RequestBody Client clientDetails) {
        getClientById(clientId);
        return clientService.updateClient(clientId, clientDetails);
    }

    //DELETE CLIENT
    @DeleteMapping("/deleteClient/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        getClientById(clientId);
        clientService.deleteClient(clientId);
    }


}
