package com.maatech.lista.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class ListItemRequestDTO {

    private UUID idUser;
    private UUID idItem;
}
