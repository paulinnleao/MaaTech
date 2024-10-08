package com.maatech.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
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
    private String dimensao;

    @Column
    private Integer avaliacao;

    @Column
    private String modelo;

    @Column
    private String tipo;

    public Item() {
    }

    public Item(UUID idItem, String name, String description, String dimensao, Integer avaliacao, String modelo, String tipo) {
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
        Item item = (Item) o;
        return Objects.equals(idItem, item.idItem) && Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(dimensao, item.dimensao) && Objects.equals(avaliacao, item.avaliacao) && Objects.equals(modelo, item.modelo) && Objects.equals(tipo, item.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, name, description, dimensao, avaliacao, modelo, tipo);
    }

    @Override
    public String toString() {
        return "Item{" +
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
