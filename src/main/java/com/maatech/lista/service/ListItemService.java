package com.maatech.lista.service;

import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.lista.entity.ListItem;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ListItemService {

    ResponseEntity<?> findListByIdUser(UUID idUser);
    ResponseEntity<List<?>> listAllLitsItems();
    ListItem addNewItemToList(UUID idUser, ItemRequestDTO itemRequestDTO);
    ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem);
}
