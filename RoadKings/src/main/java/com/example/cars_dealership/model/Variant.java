package com.example.cars_dealership.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVariant;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private Moteur moteur;

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    private Voiture voiture;

    @OneToMany(mappedBy = "variant_images", cascade = CascadeType.ALL)
    private List<Image> variant_images;

    @ElementCollection
    private List<String> features;

    @Column(nullable = false)
    private double basePrice;

    public Variant(String color , Moteur moteur , int stock , Voiture voiture , List<Image> variant_images , List<String> features, double basePrice) {
        this.color = color;
        this.moteur = moteur;
        this.stock = stock;
        this.voiture = voiture;
        this.variant_images = variant_images;
        this.features = features;
        this.basePrice = basePrice;
    }
    public Variant() {}
    // Getters & Setters
    public Long getIdVariant() {
        return idVariant;
    }

    public void setIdVariant(Long idVariant) {
        this.idVariant = idVariant;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public List<Image> getVariant_images() {
        return variant_images;
    }

    public void setVariant_images(List<Image> variant_images) {
        this.variant_images = variant_images;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }


    // methods
    public boolean isAvailable(int stockRequired) {
        return this.stock >= stockRequired;
    }

    public void decrementStock(int quantity) {
        this.stock -= quantity;
    }

    public void updateVariantImage(Image image) {
        this.variant_images.add(image);
    }

}