package com.maatech.item.rest;

import com.maatech.item.entity.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class ItemRestImp implements ItemRest{
    @Override
    public ResponseEntity<?> findItemById(UUID idItem) {
        return null;
    }

    @Override
    public List<ResponseEntity<?>> findAllItems() {
        return List.of();
    }

    @Override
    public ResponseEntity<?> createItem(ItemDTO item) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateItem(ItemDTO item) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteItemById(UUID idItem) {
        return null;
    }
}
