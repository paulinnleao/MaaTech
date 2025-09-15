package com.maatech.item.rest;

import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ItemRest {

    ResponseEntity<?> findItemById(UUID idItem);
    ResponseEntity<List<ItemResponseDTO>> findAllItems();
    ResponseEntity<ItemResponseDTO> createItem(ItemRequestDTO item);
    ResponseEntity<ItemResponseDTO> updateItem(ItemRequestDTO item);
    ResponseEntity<?> deleteItemById(UUID idItem);
}