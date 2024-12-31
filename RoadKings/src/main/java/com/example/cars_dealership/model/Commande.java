package com.example.cars_dealership.model;
import com.example.cars_dealership.enums.StatusCommande;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    @ManyToOne
    private User client;
    @ManyToOne
    private Voiture variant;
    @Enumerated(EnumType.STRING)
    private StatusCommande statusCommande;
    private BigDecimal totalPrice;
    private Date date;

    public Commande(User client , Voiture variant , StatusCommande statusCommande , BigDecimal totalPrice , Date date) {
        this.client = client;
        this.variant = variant;
        this.statusCommande = StatusCommande.EN_ATTENTE;
        this.totalPrice = totalPrice;
        this.date = date;
    }
    public Commande() {}


    //Getters & Setters

    public Long getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
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
    public StatusCommande getStatusCommande() {
        return statusCommande;
    }
    public void setStatusCommande(StatusCommande statusCommande) {this.statusCommande = statusCommande;}
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {this.date = date;}

    //methods
    public void validate() {
        this.statusCommande = StatusCommande.VALIDEE;
    }

    public void cancel() {
        this.statusCommande = StatusCommande.ANNULEE;
    }

}
