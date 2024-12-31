package com.example.cars_dealership.repository;

import com.example.cars_dealership.enums.StatusCommande;
import com.example.cars_dealership.model.Commande;
import com.example.cars_dealership.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findAllByClient(User client);

    // Find commandes by status
    List<Commande> findByStatusCommande(StatusCommande statusCommande);

}
