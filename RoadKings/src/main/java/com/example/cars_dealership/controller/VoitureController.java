package com.example.cars_dealership.controller;

import com.example.cars_dealership.model.Voiture;
import com.example.cars_dealership.service.VoitureService;
import com.example.cars_dealership.enums.PowerType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    // Display form to add a Voiture
    @GetMapping("/add")
    public String showAddVoitureForm(Model model) {
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("powerTypes", PowerType.values()); // Add PowerType for selection
        return "add_voiture"; // This is the name of the HTML template
    }

    // Handle form submission to add a new Voiture
    @PostMapping("/add")
    public String addVoiture(@ModelAttribute Voiture voiture) {
        voitureService.saveVoiture(voiture); // Assuming you have a service for saving the Voiture
        return "redirect:/voitures/list"; // Redirect to the list page after adding a Voiture
    }

    // Display all Voitures
    @GetMapping("/list")
    public String listVoitures(Model model) {
        List<Voiture> voitures = voitureService.getAllVoitures(); // Fetch all voitures
        model.addAttribute("voitures", voitures);
        return "list_voitures"; // This is the name of the Thymeleaf template for listing voitures
    }

    @GetMapping("/edit/{id}")
    public String showEditVoitureForm(@PathVariable Long id, Model model) {
        Voiture voiture = voitureService.getVoitureById(id); // Fetch Voiture by ID
        if (voiture == null) {
            return "redirect:/voitures/list"; // Redirect if Voiture not found
        }
        model.addAttribute("voiture", voiture);
        model.addAttribute("powerTypes", PowerType.values()); // Add PowerType for selection
        return "edit_voiture"; // This is the name of the HTML template for editing
    }

    // Handle form submission to update a Voiture
    @PostMapping("/edit/{id}")
    public String updateVoiture(@PathVariable Long id, @ModelAttribute Voiture voiture) {
        voiture.setIdVoiture(id); // Set the ID to ensure the correct Voiture is updated
        voitureService.saveVoiture(voiture); // Save the updated Voiture
        return "redirect:/voitures/list"; // Redirect to the list page after updating
    }


    @GetMapping("/delete/{id}")
    public String deleteVoiture(@PathVariable("id") Long id) {
        voitureService.deleteVoitureById(id);
        return "redirect:/voitures/list";  // Redirect back to the list of voitures
    }

}
