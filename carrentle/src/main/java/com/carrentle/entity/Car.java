package com.carrentle.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String type;
    private Double pricePerDay;
    private Boolean availabilityStatus;
    private String fuelType;
    private String transmission;

    private Boolean isDeleted = false;
}