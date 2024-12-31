package com.example.cars_dealership.model;
import com.example.cars_dealership.enums.StatusReservation;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ReservationTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @ManyToOne
    private User client;
    @ManyToOne
    private Voiture variant;
    @Enumerated(EnumType.STRING)
    private StatusReservation statusReservation;
    private Date date;

    public ReservationTest(User client, Voiture variant, Date date) {
        this.client = client;
        this.variant = variant;
        this.date = date;
    }
    public ReservationTest() {}


    //Getters & Setters
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Voiture getVariant() {
        return variant;
    }

    public void setVariant(Voiture variant) {
        this.variant = variant;
    }

    public StatusReservation getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(StatusReservation statusReservation) {
        this.statusReservation = statusReservation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    //methods
    public void confirm() {
        this.statusReservation = StatusReservation.CONFIRMEE;
    }

    public void complete() {
        this.statusReservation = StatusReservation.EFFECTUEE;
    }

    public void cancel() {this.statusReservation = StatusReservation.ANNULEE;}
}