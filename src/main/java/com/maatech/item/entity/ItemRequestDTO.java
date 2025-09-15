package com.maatech.item.entity;

import lombok.Data;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ItemRequestDTO {

    @Schema(description = "ID único do item (UUID)", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID idItem;

    @Schema(description = "Nome do item", example = "Notebook Dell XPS 13")
    private String name;

    @Schema(description = "Descrição do item", example = "Notebook com processador Intel i7, 16GB RAM, 512GB SSD")
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
}