package com.smartfarmer.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Crop {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cropType;
    private String variety;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    private LocalDate sowingDate;
    private LocalDate expectedHarvestDate;
    private Double expectedYield;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCropType() { return cropType; }
    public void setCropType(String cropType) { this.cropType = cropType; }
    public String getVariety() { return variety; }
    public void setVariety(String variety) { this.variety = variety; }
    public Field getField() { return field; }
    public void setField(Field field) { this.field = field; }
    public LocalDate getSowingDate() { return sowingDate; }
    public void setSowingDate(LocalDate sowingDate) { this.sowingDate = sowingDate; }
    public LocalDate getExpectedHarvestDate() { return expectedHarvestDate; }
    public void setExpectedHarvestDate(LocalDate expectedHarvestDate) { this.expectedHarvestDate = expectedHarvestDate; }
    public Double getExpectedYield() { return expectedYield; }
    public void setExpectedYield(Double expectedYield) { this.expectedYield = expectedYield; }
}
