package com.maatech.lista.service;

import com.maatech.exception.ResourceNotFoundException;
import com.maatech.item.entity.Item;
import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import com.maatech.item.mapper.ItemMapper;
import com.maatech.item.service.ItemService;
import com.maatech.lista.entity.ListItem;
import com.maatech.lista.entity.ListItemResponseDTO;
import com.maatech.lista.mapper.ListItemMapper;
import com.maatech.lista.repository.ListItemRepository;
import com.maatech.user.entity.User;
import com.maatech.user.mapper.UserMapper;
import com.maatech.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ListItemServiceImp implements ListItemService {

    @Autowired
    ListItemRepository repository;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ListItemMapper listItemMapper;

    @Override
    public List<ListItemResponseDTO> findUserItemList(UUID idUser) {
        List<ListItem> userItemList = repository.findUserItemList(idUser);
        List<ListItemResponseDTO> userItemListResponse = new ArrayList<>();

        userItemList.forEach(item -> userItemListResponse.add(
                listItemMapper.fromEntityToListItemResponseDTO(item)
        ));

        if(userItemList.isEmpty()){
            throw new ResourceNotFoundException("There isn't list for this UUID: " + idUser);
        }

        return userItemListResponse;
    }

    @Override
    public ResponseEntity<List<?>> listAllLitsItems() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ListItemResponseDTO addNewItemToList(UUID idUser, ItemRequestDTO itemRequestDTO) {
        if(repository.findById(new ListItem.ListItemId(idUser, itemRequestDTO.getIdItem())).isEmpty()){
            ListItemResponseDTO responseDTO;

            User user = userMapper.fromResponseDtoToEntity(userService.findUserById(idUser));
            ItemResponseDTO itemResponseDTO = itemService.findItemById(itemRequestDTO.getIdItem());

            Item item;

            if(Objects.nonNull(itemResponseDTO)){

                item = itemMapper.fromResponseDtoToEntity(itemResponseDTO);
                // Verificar se está autenticado na v2
                responseDTO = listItemMapper.fromEntityToListItemResponseDTO(repository.save(new ListItem(user, item)));
            }else{
                item = itemMapper.fromResponseDtoToEntity(itemService.createItem(itemRequestDTO));
                responseDTO = listItemMapper.fromEntityToListItemResponseDTO(repository.save(new ListItem(user, item)));
            }

            return responseDTO;
        }
        return null;
    }

    @Override
    public ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem) {
        ListItemResponseDTO listItemResponseDTO = findListItemById(idUser, idItem);
        if(Objects.nonNull(listItemResponseDTO)){
            repository.delete(listItemMapper.fromResponseDtoToEntity(listItemResponseDTO));
            return ResponseEntity.noContent().build();
        }else{
            throw new ResourceNotFoundException("This item there isn't in user list. idUser: " + idUser + ", idItem: " + idItem);
        }
    }

    @Override
    public ListItemResponseDTO findListItemById(UUID idUser, UUID idItem){
        ListItem listItem = repository.findById(
                new ListItem.ListItemId(idUser, idItem))
                .orElseThrow(
                        () -> new ResourceNotFoundException("This item there isn't in user list. idUser: " + idUser + ", idItem: " + idItem));

        return listItemMapper.fromEntityToListItemResponseDTO(listItem);
    }
}
