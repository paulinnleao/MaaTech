package com.maatech.item.rest;

import com.maatech.item.entity.ItemRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ItemRest {

    ResponseEntity<?> findItemById(UUID idItem);
    List<ResponseEntity<?>> findAllItems();
    ResponseEntity<?> createItem(ItemRequestDTO item);
    ResponseEntity<?> updateItem(ItemRequestDTO item);
    ResponseEntity<?> deleteItemById(UUID idItem);
}