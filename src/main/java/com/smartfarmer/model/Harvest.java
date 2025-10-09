package com.smartfarmer.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Harvest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crop;
    private LocalDate harvestDate;
    private Double actualYield;
    private Double pricePerUnit;
    private String buyer;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCrop() { return crop; }
    public void setCrop(String crop) { this.crop = crop; }
    public LocalDate getHarvestDate() { return harvestDate; }
    public void setHarvestDate(LocalDate harvestDate) { this.harvestDate = harvestDate; }
    public Double getActualYield() { return actualYield; }
    public void setActualYield(Double actualYield) { this.actualYield = actualYield; }
    public Double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(Double pricePerUnit) { this.pricePerUnit = pricePerUnit; }
    public String getBuyer() { return buyer; }
    public void setBuyer(String buyer) { this.buyer = buyer; }
}
