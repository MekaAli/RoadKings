package com.example.cars_dealership.service;

import com.example.cars_dealership.enums.StatusReservation;
import com.example.cars_dealership.model.ReservationTest;
import com.example.cars_dealership.model.User;
import com.example.cars_dealership.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //Confirme Reservation
    public void confirmationReservation(ReservationTest reservation) {
        reservation.confirm();
        reservationRepository.save(reservation);
    }

    //Annulee Commande
    public void cancelCommande(ReservationTest reservation) {
        reservation.cancel(); // Call the entity method
        reservationRepository.save(reservation); // Persist the change using the instance
    }

    //Reservation Effectuee
    public void completeCommande(ReservationTest reservation) {
        reservation.complete();
        reservationRepository.save(reservation);
    }

    //Get all Reservations for a Client
    public List<ReservationTest> getReservationsByClient(User client) {
        return reservationRepository.findAllByClient(client);
    }

    // Get all reservations
    public List<ReservationTest> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Get reservations by status
    public List<ReservationTest> getReservationsByStatus(StatusReservation status) {
        return reservationRepository.findByStatusReservation(status);
    }

}