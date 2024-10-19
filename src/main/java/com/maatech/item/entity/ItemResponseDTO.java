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
    private Double avaragePrice;
    private String category;
    private String rating;
    private String reviewCount;
    private String wight;

    public ItemResponseDTO() {
    }

    public ItemResponseDTO(UUID idItem, String name, String description, String model, String brand, Double avaragePrice, String category, String rating, String reviewCount, String wight) {
        this.idItem = idItem;
        this.name = name;
        this.description = description;
        this.model = model;
        this.brand = brand;
        this.avaragePrice = avaragePrice;
        this.category = category;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.wight = wight;
    }
}
