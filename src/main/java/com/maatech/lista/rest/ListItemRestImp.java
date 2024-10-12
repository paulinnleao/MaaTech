package com.maatech.lista.rest;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class ListItemRestImp implements ListItemRest{
    @Override
    public List<ResponseEntity<?>> findListByIdUser(UUID idUser) {
        return List.of();
    }

    @Override
    public List<ResponseEntity<?>> listAllLitsItems() {
        return List.of();
    }

    @Override
    public ResponseEntity<?> addNewItemToList(UUID idUser, UUID idItem) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem) {
        return null;
    }
}
