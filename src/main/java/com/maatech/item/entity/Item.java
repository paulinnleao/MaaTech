package com.maatech.item.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "ITEMS")
public class Item implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "iditem")
    private UUID idItem;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String model;

    @Column
    private String brand;

    @Column(name = "averageprice")
    private Double averagePrice;

    @Column
    private String category;

    @Column
    private String rating;

    @Column(name = "reviewcount")
    private String reviewCount;

    @Column
    private String weight;

    public Item() {
    }

    public Item(UUID idItem, String name, String description, String model, String brand, Double averagePrice, String category, String rating, String reviewCount, String weight) {
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
