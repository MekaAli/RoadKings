package com.example.cars_dealership.model;
import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    @Column(nullable = false)
    private String imageUrl; // Path to the image file (e.g., /images/voiture1.jpg)

    @ManyToOne
    @JoinColumn(name = "voiture_id") // Explicit foreign key column
    private Voiture voiture_images; // Reference to the related Voiture

    @ManyToOne
    @JoinColumn(name = "variant_id") // Explicit foreign key column
    private Variant variant_images; // Reference to the related Variant

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Image() {}


    // Getters & Setters
    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Voiture getVoiture_images() {
        return voiture_images;
    }

    public void setVoiture_images(Voiture voiture_images) {
        this.voiture_images = voiture_images;
    }

    public Variant getVariant_images() {
        return variant_images;
    }

    public void setVariant_images(Variant variant_images) {
        this.variant_images = variant_images;
    }
}

