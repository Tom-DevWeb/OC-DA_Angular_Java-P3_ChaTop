package com.chatop.p3chatop.mappers;

import com.chatop.p3chatop.dto.RentalRequestDTO;
import com.chatop.p3chatop.dto.RentalResponseDTO;
import com.chatop.p3chatop.entities.Rental;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    RentalResponseDTO toRentalResponseDTO(Rental rental);

    Rental toRental(RentalRequestDTO rentalRequestDTO);

    Rental toRental(RentalResponseDTO rentalResponseDTO);

    List<RentalResponseDTO> toRentalResponseDTOs(List<Rental> rentals);

    List<Rental> toRentals(List<RentalResponseDTO> rentalResponseDTOs);
}
