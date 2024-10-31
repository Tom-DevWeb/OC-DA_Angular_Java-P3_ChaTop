package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.RentalMsgResponseDTO;
import com.chatop.p3chatop.dto.RentalRequestDTO;
import com.chatop.p3chatop.dto.RentalResponseDTO;
import com.chatop.p3chatop.services.RentalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Rental", description = "Rental management APIs")
@RequestMapping("/rentals")
@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("")
    public ResponseEntity<Map<String, List<RentalResponseDTO>>> getRentals() {

        List<RentalResponseDTO> rentalResponseDTOs = rentalService.getRentals();

        Map<String, List<RentalResponseDTO>> response = new HashMap<>();
        response.put("rentals", rentalResponseDTOs);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalResponseDTO> getRental(@PathVariable Integer id) {
        RentalResponseDTO rentalResponseDTO = rentalService.getRental(id);

        return ResponseEntity.ok(rentalResponseDTO);
    }

    @PostMapping(value = "")
    public ResponseEntity<RentalMsgResponseDTO> createRental(@Valid @ModelAttribute RentalRequestDTO rentalRequestDTO) {
        RentalMsgResponseDTO response = rentalService.createRental(rentalRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalMsgResponseDTO> updateRental(@PathVariable Integer id, @Valid @ModelAttribute RentalRequestDTO rentalRequestDTO) {
        RentalMsgResponseDTO response = rentalService.updateRental(id, rentalRequestDTO);

        return ResponseEntity.ok(response);
    }


}
