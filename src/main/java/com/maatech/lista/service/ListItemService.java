package com.maatech.lista.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ListItemService {

    ResponseEntity<?> findListByIdUser(UUID idUser);
    ResponseEntity<List<?>> listAllLitsItems();
    ResponseEntity<?> addNewItemToList(UUID idUser, UUID idItem);
    ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem);
}
