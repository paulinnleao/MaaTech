package com.maatech.lista.rest;

import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import com.maatech.lista.entity.ListItem;
import com.maatech.lista.entity.ListItemResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ListItemRest {

    ResponseEntity<List<ItemResponseDTO>> findUserItemList(UUID idUser);
    List<ResponseEntity<?>> listAllLitsItems();
    ResponseEntity<ListItemResponseDTO> addNewItemToList(UUID idUser, ItemRequestDTO itemRequestDTO);
    ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem);
}
