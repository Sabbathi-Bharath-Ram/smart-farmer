package com.smartfarmer.model;

import jakarta.persistence.*;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double area;
    private String location;
    private String soilType;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getArea() { return area; }
    public void setArea(Double area) { this.area = area; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }
}
