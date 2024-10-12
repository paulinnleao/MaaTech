package com.maatech.lista.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ListaItemService {

    List<ResponseEntity<?>> findListByIdUser(UUID idUser);
    List<ResponseEntity<?>> listAllLitsItems();
    ResponseEntity<?> addNewItemToList(UUID idUser, UUID idItem);
    ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem);
}
