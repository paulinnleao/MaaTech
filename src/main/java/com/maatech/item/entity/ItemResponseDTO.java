package com.maatech.item.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ItemResponseDTO {

    @Schema(description = "ID único do item (UUID)", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID idItem;

    @Schema(description = "Nome do item", example = "Notebook Dell XPS 13")
    private String name;

    @Schema(description = "Descrição detalhada do item", example = "Notebook com processador Intel i7, 16GB RAM, 512GB SSD")
    private String description;

    @Schema(description = "Modelo do item", example = "XPS 13 9310")
    private String model;

    @Schema(description = "Marca do item", example = "Dell")
    private String brand;

    @Schema(description = "Preço médio do item", example = "7500.0")
    private Double averagePrice;

    @Schema(description = "Categoria do item", example = "Notebook")
    private String category;

    @Schema(description = "Avaliação média do item", example = "4.5")
    private String rating;

    @Schema(description = "Quantidade de avaliações", example = "120")
    private String reviewCount;

    @Schema(description = "Peso do item", example = "1.2kg")
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
