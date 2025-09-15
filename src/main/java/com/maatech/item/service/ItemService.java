package com.maatech.item.service;

import com.maatech.item.entity.Item;
import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    ItemResponseDTO findItemById(UUID idItem);
    List<ItemResponseDTO> findAllItems();
    ItemResponseDTO createItem(ItemRequestDTO item);
    ItemResponseDTO updateItem(ItemRequestDTO item);
    void deleteItemById(UUID idItem);
}
