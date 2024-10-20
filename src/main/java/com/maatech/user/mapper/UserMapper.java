package com.maatech.user.mapper;

import com.maatech.user.entity.User;
import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.entity.dto.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromRequestDtoToEntity(UserRequestDTO dto);
    User fromResponseDtoToEntity(UserResponseDTO dto);

    UserRequestDTO fromEntityToRequestDTO(User user);
    UserResponseDTO fromEntityToResponseDTO(User user);
}
