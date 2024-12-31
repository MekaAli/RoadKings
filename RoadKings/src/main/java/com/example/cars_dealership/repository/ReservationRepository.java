package com.example.cars_dealership.repository;

import com.example.cars_dealership.enums.StatusReservation;
import com.example.cars_dealership.model.ReservationTest;
import com.example.cars_dealership.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationTest, Long> {
    List<ReservationTest> findAllByClient(User client);

    // Find reservations by status
    List<ReservationTest> findByStatusReservation(StatusReservation statusReservation);

}