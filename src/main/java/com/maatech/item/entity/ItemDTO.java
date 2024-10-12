package com.maatech.item.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class ItemDTO {

    private UUID idItem;
    private String name;
    private String description;
    private String dimensao;
    private Integer avaliacao;
    private String modelo;
    private String tipo;

    public ItemDTO() {
    }

    public ItemDTO(UUID idItem, String name, String description, String dimensao, Integer avaliacao, String modelo, String tipo) {
        this.idItem = idItem;
        this.name = name;
        this.description = description;
        this.dimensao = dimensao;
        this.avaliacao = avaliacao;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(idItem, itemDTO.idItem) && Objects.equals(name, itemDTO.name) && Objects.equals(description, itemDTO.description) && Objects.equals(dimensao, itemDTO.dimensao) && Objects.equals(avaliacao, itemDTO.avaliacao) && Objects.equals(modelo, itemDTO.modelo) && Objects.equals(tipo, itemDTO.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, name, description, dimensao, avaliacao, modelo, tipo);
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "idItem=" + idItem +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dimensao='" + dimensao + '\'' +
                ", avaliacao=" + avaliacao +
                ", modelo='" + modelo + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}