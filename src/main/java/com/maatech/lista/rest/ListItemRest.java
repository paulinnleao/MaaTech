package com.maatech.lista.rest;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ListItemRest {

    List<ResponseEntity<?>> findListByIdUser(UUID idUser);
    List<ResponseEntity<?>> listAllLitsItems();
    ResponseEntity<?> addNewItemToList(UUID idUser, UUID idItem);
    ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem);
}
