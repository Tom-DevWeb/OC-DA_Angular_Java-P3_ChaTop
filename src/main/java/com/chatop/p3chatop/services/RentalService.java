package com.chatop.p3chatop.services;


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

    public RentalService(
            UserIdService userIdService,
            RentalRepository rentalRepository,
            RentalMapper rentalMapper) {
        this.userIdService = userIdService;
        this.rentalRepository = rentalRepository;
        this.rentalMapper = rentalMapper;
    }

    public List<RentalResponseDTO> getRentals() {

        List<Rental> rentals = rentalRepository.findAll();

        return rentalMapper.toRentalResponseDTOs(rentals);
    }


    public RentalResponseDTO getRental(Integer id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();

        return rentalMapper.toRentalResponseDTO(rental);
    }


    public RentalResponseDTO createRental(RentalRequestDTO rentalRequestDTO) {
        Rental rental = rentalMapper.toRental(rentalRequestDTO);

        rental.setOwnerId(userIdService.getId());

        Rental savedRental = rentalRepository.save(rental);

        return rentalMapper.toRentalResponseDTO(savedRental);
    }

    public RentalResponseDTO updateRental(Integer id, RentalRequestDTO rentalRequestDTO) {
        Rental rental = rentalRepository.findById(id).orElseThrow();


        Rental updatedRental = rentalRepository.save(rental);

        return rentalMapper.toRentalResponseDTO(updatedRental);
    }
}
