package com.maatech.item.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemResponseDTO {

    private UUID idItem;
    private String name;
    private String description;
    private String model;
    private String brand;
    private Double averagePrice;
    private String category;
    private String rating;
    private String reviewCount;
    private String weight;

    public ItemResponseDTO() {
    }

    public ItemResponseDTO(UUID idItem, String name, String description, String model, String brand, Double averagePrice, String category, String rating, String reviewCount, String weight) {
        this.idItem = idItem;
        this.name = name;
        this.description = description;
        this.model = model;
        this.brand = brand;
        this.averagePrice = averagePrice;
        this.category = category;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.weight = weight;
    }
}
