package com.maatech.lista.service;

import com.maatech.exception.ResourceNotFoundException;
import com.maatech.lista.entity.ListItem;
import com.maatech.lista.repository.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListItemServiceImp implements ListItemService {

    @Autowired
    ListItemRepository repository;

    @Override
    public ResponseEntity<?> findListByIdUser(UUID idUser) {
        List<ListItem> userItemList = repository.findUserItemList(idUser);

        if(userItemList.isEmpty()){
            throw new ResourceNotFoundException("There isn't list for this UUID: " + idUser);
        }

        return ResponseEntity.ok(userItemList);
    }

    @Override
    public ResponseEntity<List<?>> listAllLitsItems() {
        return ResponseEntity.ok(repository.findAll());
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
