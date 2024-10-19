package com.maatech.item.entity;

import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ItemDTO {

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

    public ItemDTO() {
    }

    public ItemDTO(UUID idItem, String name, String description, String model, String brand, Double avaragePrice, String category, String rating, String reviewCount, String wight) {
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