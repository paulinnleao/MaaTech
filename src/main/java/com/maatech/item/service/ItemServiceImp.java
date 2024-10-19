package com.maatech.item.service;

import com.maatech.exception.ResourceNotFoundException;
import com.maatech.item.entity.Item;
import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import com.maatech.item.mapper.ItemMapper;
import com.maatech.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository repository;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public ItemResponseDTO findItemById(UUID idItem) {
        Item item = repository.findById(idItem)
                .orElseThrow(
                        () -> new ResourceNotFoundException("There isn't item with this UUID: " + idItem));

        return  itemMapper.fromEntityToResponseDTO(item);
    }

    @Override
    public List<ResponseEntity<?>> findAllItems() {
        return List.of();
    }

    @Override
    public ItemResponseDTO createItem(ItemRequestDTO itemRequestDTO) {

        if(Objects.isNull(findItemById(itemRequestDTO.getIdItem()))){
            Item newItem = itemMapper
                    .fromRequestDtoToEntity(itemRequestDTO);

            return itemMapper
                    .fromEntityToResponseDTO(repository.save(newItem));
        }

        return null;
    }

    @Override
    public ResponseEntity<?> updateItem(ItemRequestDTO item) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteItemById(UUID idItem) {
        return null;
    }
}
