package com.maatech.lista.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class ListItemResponseDTO {

    private UUID idUser;
    private UUID idItem;
}
