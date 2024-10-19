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
@Table(name = "ITENS")
public class Item implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idItem;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String model;

    @Column
    private String brand;

    @Column
    private Double avaragePrice;

    @Column
    private String category;

    @Column
    private String rating;

    @Column
    private String reviewCount;

    @Column
    private String wight;

    public Item() {
    }

    public Item(UUID idItem, String name, String description, String model, String brand, Double avaragePrice, String category, String rating, String reviewCount, String wight) {
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
