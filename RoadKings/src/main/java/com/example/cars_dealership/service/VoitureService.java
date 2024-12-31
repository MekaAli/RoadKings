package com.example.cars_dealership.service;

import com.example.cars_dealership.model.Voiture;
import com.example.cars_dealership.repository.VoitureRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    // Save a new Voiture to the database
    public void saveVoiture(Voiture voiture) {
        voitureRepository.save(voiture);
    }

    // Get all Voitures
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll(); // Retrieve all Voitures from the database
    }

    // Get a Voiture by ID
    public Voiture getVoitureById(Long id) {
        return voitureRepository.findById(id).orElse(null); // Return null if not found
    }

    public void deleteVoitureById(Long id) {
        voitureRepository.deleteById(id);
    }    

}
