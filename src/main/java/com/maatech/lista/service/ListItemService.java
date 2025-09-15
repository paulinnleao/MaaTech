package com.maatech.lista.service;

import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.lista.entity.ListItemResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ListItemService {

    List<ListItemResponseDTO> findUserItemList(UUID idUser);
    ResponseEntity<List<?>> listAllLitsItems();
    ListItemResponseDTO addNewItemToList(UUID idUser, ItemRequestDTO itemRequestDTO);
    void deleteItemFromUserList(UUID idUser, UUID idItem);
    ListItemResponseDTO findListItemById(UUID idUser, UUID idItem);
}
