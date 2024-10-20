package com.maatech.lista.mapper;

import com.maatech.lista.entity.ListItem;
import com.maatech.lista.entity.ListItemRequestDTO;
import com.maatech.lista.entity.ListItemResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListItemMapper {

    ListItem fromResponseDtoToEntity (ListItemResponseDTO dto);
    ListItem fromRequestDtoToEntity (ListItemRequestDTO dto);

    ListItemRequestDTO fromEntityToListItemRequestDTO (ListItem listItem);
    ListItemResponseDTO fromEntityToListItemResponseDTO (ListItem listItem);

}
