package com.chatop.p3chatop.services;


import com.chatop.p3chatop.dto.RentalMsgResponseDTO;
import com.chatop.p3chatop.dto.RentalRequestDTO;
import com.chatop.p3chatop.dto.RentalResponseDTO;
import com.chatop.p3chatop.entities.Rental;
import com.chatop.p3chatop.mappers.RentalMapper;
import com.chatop.p3chatop.repositories.RentalRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class RentalService {

    public final UserIdService userIdService;
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    public final ImageFileService imageFileService;

    public RentalService(
            UserIdService userIdService,
            RentalRepository rentalRepository,
            RentalMapper rentalMapper,
            ImageFileService imageFileService) {
        this.userIdService = userIdService;
        this.rentalRepository = rentalRepository;
        this.rentalMapper = rentalMapper;
        this.imageFileService = imageFileService;
    }

    public List<RentalResponseDTO> getRentals() {

        List<Rental> rentals = rentalRepository.findAll();

        return rentalMapper.toRentalResponseDTOs(rentals);
    }


    public RentalResponseDTO getRental(Integer id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();

        return rentalMapper.toRentalResponseDTO(rental);
    }


    public RentalMsgResponseDTO createRental(RentalRequestDTO rentalRequestDTO) {

        String imagePath = imageFileService.uploadImage(rentalRequestDTO.getPicture());

        Rental rental = rentalMapper.toRental(rentalRequestDTO);

        rental.setPicture(imagePath);
        rental.setOwnerId(userIdService.getId());

        rentalRepository.save(rental);

        return new RentalMsgResponseDTO("Rental created !");
    }

    public RentalMsgResponseDTO updateRental(Integer id, RentalRequestDTO rentalRequestDTO) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        if (rentalRequestDTO.getName() != null) {
            rental.setName(rentalRequestDTO.getName());
        }
        if (rentalRequestDTO.getSurface() != null) {
            rental.setSurface(rentalRequestDTO.getSurface());
        }
        if (rentalRequestDTO.getPrice() != null) {
            rental.setPrice(rentalRequestDTO.getPrice());
        }
        if (rentalRequestDTO.getDescription() != null) {
            rental.setDescription(rentalRequestDTO.getDescription());
        }

        rentalRepository.save(rental);

        return new RentalMsgResponseDTO("Rental updated !");
    }
}
