package com.chatop.p3chatop.mappers;


import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // MeResponseDTO < User
    @Mapping(source = "createdAt", target = "created_at")
    @Mapping(source = "updatedAt", target = "updated_at")
    MeResponseDTO toUserDTO(User user);
}
