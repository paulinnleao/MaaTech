package com.maatech.item.service;

import com.maatech.item.entity.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImp implements ItemService{
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
