package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.RentalRequestDTO;
import com.chatop.p3chatop.dto.RentalResponseDTO;
import com.chatop.p3chatop.services.RentalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rental", description = "Rental management APIs")
@RequestMapping("/rentals")
@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("")
    public ResponseEntity<List<RentalResponseDTO>> getRentals() {
        List<RentalResponseDTO> rentalResponseDTOs = rentalService.getRentals();

        return ResponseEntity.ok(rentalResponseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalResponseDTO> getRental(@PathVariable Integer id) {
        RentalResponseDTO rentalResponseDTO = rentalService.getRental(id);

        return ResponseEntity.ok(rentalResponseDTO);
    }

    @PostMapping("")
    public ResponseEntity<RentalResponseDTO> createRental(@RequestBody RentalRequestDTO rentalRequestDTO) {
        RentalResponseDTO rentalResponseDTO = rentalService.createRental(rentalRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(rentalResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalResponseDTO> updateRental(@PathVariable Integer id, @RequestBody RentalRequestDTO rentalRequestDTO) {
        RentalResponseDTO rentalResponseDTO = rentalService.updateRental(id, rentalRequestDTO);

        return ResponseEntity.ok(rentalResponseDTO);
    }


}
