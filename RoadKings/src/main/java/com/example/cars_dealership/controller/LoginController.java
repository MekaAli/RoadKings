package com.example.cars_dealership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login.html view
    }
    @GetMapping("/catalog")
    public String Catalog() {
        return "catalog"; // Redirects to clientCatalog.html
    }

    @GetMapping("/stock")
    public String Stock() {
        return "stock"; // Redirects to marketingStock.html
    }

    @GetMapping("/reservations")
    public String Reservations() {
        return "reservations"; // Redirects to testReservations.html
    }

    @GetMapping("/commandes")
    public String Commandes() {
        return "commandes"; // Redirects to commercialCommandes.html
    }
    
}
