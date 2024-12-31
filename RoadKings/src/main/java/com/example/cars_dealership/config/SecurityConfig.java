package com.example.cars_dealership.config;

import com.example.cars_dealership.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (only for development, enable for production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/signup").permitAll() // Public endpoints
                        .requestMatchers("/marketing/**").hasRole("AGENT_MARKETING")
                        .requestMatchers("/commercial/**").hasRole("AGENT_COMMERCIAL")
                        .requestMatchers("/test/**").hasRole("AGENT_TEST")
                        .requestMatchers("/client/**").hasRole("CLIENT")
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .successHandler(customAuthenticationSuccessHandler()) // Custom success handler
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LoginService customAuthenticationSuccessHandler() {
        return new LoginService();
    }
    //@Bean
    //CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        //return args -> {
            //userRepository.save(new User("Abdo","Bokh","0123456789","client@example.com",Role.CLIENT, passwordEncoder.encode("password")));
            //userRepository.save(new User("Abdo","Bokh","0123456789","marketing@example.com",Role.AGENT_MARKETING ,passwordEncoder.encode("password")));
            //userRepository.save(new User("Abdo","Bokh","0123456789","test@example.com",Role.AGENT_TEST, passwordEncoder.encode("password")));
            //userRepository.save(new User("Abdo","Bokh","0123456789","commercial@example.com", Role.AGENT_COMMERCIAL, passwordEncoder.encode("password")));
        //};
    //}
}


