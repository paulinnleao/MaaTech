package com.maatech.lista.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListaItemServiceImp implements ListaItemService {
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
