package com.example.cars_dealership.service;

import com.example.cars_dealership.enums.StatusCommande;
import com.example.cars_dealership.model.Commande;
import com.example.cars_dealership.model.User;
import com.example.cars_dealership.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    //Validate Commande
    public void validateCommande(Commande commande) {
        commande.validate(); // Call the entity method
        commandeRepository.save(commande); // Persist the change using the instance
    }

    //Annulee Commande
    public void cancelCommande(Commande commande) {
        commande.cancel(); // Call the entity method
        commandeRepository.save(commande); // Persist the change using the instance
    }

    //Get all commandes for a Client
    public List<Commande> getCommandesByClient(User client) {
        return commandeRepository.findAllByClient(client);
    }

    // Get all commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Get commandes by status
    public List<Commande> getCommandesByStatus(StatusCommande status) {
        return commandeRepository.findByStatusCommande(status);
    }
}

