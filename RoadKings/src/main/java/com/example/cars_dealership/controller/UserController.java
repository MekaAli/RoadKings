package com.example.cars_dealership.controller;

import com.example.cars_dealership.model.User;
import com.example.cars_dealership.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String userPage(Model model) {
        // Get the currently authenticated user's email/username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); // Default Spring Security provides email as the principal

        // Fetch the user from the database
        User user = userRepository.findByAdresseEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Add the user object to the model
        model.addAttribute("user", user);

        return "user"; // Returns the user.html template
    }
    
}
