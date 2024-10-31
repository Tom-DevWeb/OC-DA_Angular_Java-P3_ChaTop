package com.chatop.p3chatop.mappers;

import com.chatop.p3chatop.dto.MessageRequestDTO;
import com.chatop.p3chatop.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    // Message < MessageRequestDTO
    @Mapping(source = "user_id", target = "user")
    @Mapping(source = "rental_id", target = "rental")
    Message toMessage(MessageRequestDTO messageRequestDTO);

}
