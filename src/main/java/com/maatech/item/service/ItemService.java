package com.maatech.item.service;

import com.maatech.item.entity.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    ResponseEntity<?> findItemById(UUID idItem);
    List<ResponseEntity<?>> findAllItems();
    ResponseEntity<?> createItem(ItemDTO item);
    ResponseEntity<?> updateItem(ItemDTO item);
    ResponseEntity<?> deleteItemById(UUID idItem);
}
