package com.example.cars_dealership.model;
import com.example.cars_dealership.enums.PowerType;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Voiture;

    @Column(nullable = false)
    private String model_Name;

    private String description;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private BigDecimal base_Price;

    @OneToMany(mappedBy = "voiture_images", cascade = CascadeType.ALL)
    private List<Image> voiture_images;

    @Enumerated(EnumType.STRING)
    private PowerType energie;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<Variant> variants;

    public Voiture(String modelName,String description, String marque, BigDecimal basePrice, List<Image> voiture_images, PowerType energie) {
        this.model_Name = modelName;
        this.description = description;
        this.marque = marque;
        this.base_Price = basePrice;
        this.voiture_images = voiture_images;
        this.energie = energie;
    }
    public Voiture() {}
    //Getters & Setters

    public Long getIdVoiture() {
        return id_Voiture;
    }

    public void setIdVoiture(Long idVoiture) {
        this.id_Voiture = idVoiture;
    }

    public String getModelName() {
        return model_Name;
    }

    public void setModelName(String modelName) {
        this.model_Name = modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public BigDecimal getBasePrice() {
        return base_Price;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.base_Price = basePrice;
    }

    public List<Image> getVoiture_images() {
        return voiture_images;
    }

    public void setVoiture_images(List<Image> voiture_images) {
        this.voiture_images = voiture_images;
    }

    public PowerType getEnergie() {
        return energie;
    }

    public void setEnergie(PowerType energie) {
        this.energie = energie;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }


}
