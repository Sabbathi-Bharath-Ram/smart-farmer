package com.smartfarmer.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Expense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate expenseDate;
    private Double amount;
    private String category;
    private String reference;
    private String description;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getExpenseDate() { return expenseDate; }
    public void setExpenseDate(LocalDate expenseDate) { this.expenseDate = expenseDate; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
