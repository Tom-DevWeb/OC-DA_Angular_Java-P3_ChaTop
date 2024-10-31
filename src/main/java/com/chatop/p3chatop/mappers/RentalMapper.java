package com.chatop.p3chatop.mappers;

import com.chatop.p3chatop.dto.RentalRequestDTO;
import com.chatop.p3chatop.dto.RentalResponseDTO;
import com.chatop.p3chatop.entities.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    //RentalResponseDTO < Rental
    @Mapping(source = "ownerId", target = "owner_id")
    @Mapping(source = "createdAt", target = "created_at")
    @Mapping(source = "updatedAt", target = "updated_at")
    RentalResponseDTO toRentalResponseDTO(Rental rental);

    //Rental < RentalRequestDTO
    @Mapping(source = "picture", target = "picture", qualifiedByName = "mapPicture")
    Rental toRental(RentalRequestDTO rentalRequestDTO);
    @Named("mapPicture")
    default String mapPicture(MultipartFile picture) {
        if (picture != null) {
            return picture.getOriginalFilename();
        } else {
            return null;
        }
    }

    //List RentalResponseDTO < List Rental
    List<RentalResponseDTO> toRentalResponseDTOs(List<Rental> rentals);
}
