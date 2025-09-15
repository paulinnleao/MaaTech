package com.maatech.lista.entity;

import lombok.Data;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ListItemResponseDTO {

    @Schema(description = "ID do usuário dono da lista", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID idUser;

    @Schema(description = "ID do item presente na lista do usuário", example = "7c9e6679-7425-40de-944b-e07fc1f90ae7")
    private UUID idItem;
}
