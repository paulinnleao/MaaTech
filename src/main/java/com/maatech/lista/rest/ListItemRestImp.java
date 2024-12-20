package com.maatech.lista.rest;

import com.maatech.item.entity.Item;
import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import com.maatech.item.service.ItemService;
import com.maatech.lista.entity.ListItem;
import com.maatech.lista.entity.ListItemResponseDTO;
import com.maatech.lista.service.ListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/list-of-items")
public class ListItemRestImp implements ListItemRest{

    @Autowired
    ListItemService service;

    @Autowired
    ItemService itemService;

    @Override
    @GetMapping("/{idUser}")
    public ResponseEntity<List<ItemResponseDTO>> findUserItemList(@PathVariable("idUser") UUID idUser) {
        List<ListItemResponseDTO> listsUser = service.findUserItemList(idUser);
        List<ItemResponseDTO> listItems = new ArrayList<>();
        listsUser.forEach(list -> listItems.add(itemService.findItemById(list.getIdItem())));
        return ResponseEntity.ok(listItems);

    }

    @Override
    @GetMapping
    public List<ResponseEntity<?>> listAllLitsItems() {
        return List.of();
    }

    @Override
    @PostMapping("/{idUser}")
    public ResponseEntity<ListItemResponseDTO> addNewItemToList(@PathVariable("idUser") UUID idUser, @RequestBody ItemRequestDTO itemRequestDTO) {
        return ResponseEntity.ok(service.addNewItemToList(idUser, itemRequestDTO));
    }

    @Override
    @DeleteMapping("/{idUser}/{idItem}")
    public ResponseEntity<?> deleteItemFromUserList(@PathVariable("idUser") UUID idUser, @PathVariable("idItem") UUID idItem) {
        return service.deleteItemFromUserList(idUser, idItem);
    }
}
