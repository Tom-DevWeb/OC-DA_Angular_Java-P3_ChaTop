package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.RentalMsgResponseDTO;
import com.chatop.p3chatop.dto.RentalRequestDTO;
import com.chatop.p3chatop.dto.RentalResponseDTO;
import com.chatop.p3chatop.services.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    /**
     * GET /rentals/ => Récupérer toutes les locations
     * @return
     */
    @Operation(
            summary = "Récupérer toutes les locations",
            description = "Récupère la liste de toutes les locations.",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @Parameters({
            @Parameter(
                    name = "Authorization", description = "Bearer Token", required = true
            )
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = RentalResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "401",
                    content = { @Content(schema = @Schema()) })
    })
    @GetMapping("")
    public ResponseEntity<Map<String, List<RentalResponseDTO>>> getRentals() {

        List<RentalResponseDTO> rentalResponseDTOs = rentalService.getRentals();

        Map<String, List<RentalResponseDTO>> response = new HashMap<>();
        response.put("rentals", rentalResponseDTOs);

        return ResponseEntity.ok(response);
    }

    /**
     * GET /rentals/{id} => Récupérer une location par ID
     * @param id
     * @return
     */
    @Operation(
            summary = "Récupérer une location par ID",
            description = "Récupère les informations d'une location en fonction de son ID.",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @Parameters({
            @Parameter(
                    name = "Authorization", description = "Bearer Token", required = true
            )
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = RentalResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "401",
                    content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public ResponseEntity<RentalResponseDTO> getRental(@PathVariable Integer id) {
        RentalResponseDTO rentalResponseDTO = rentalService.getRental(id);

        return ResponseEntity.ok(rentalResponseDTO);
    }

    /**
     * POST /rentals/{id} => Créer une location
     * @param rentalRequestDTO
     * @return
     */
    @Operation(
            summary = "Créer une nouvelle location",
            description = "Permet de créer une nouvelle location avec les informations fournies.",
            security = { @SecurityRequirement(name = "bearerAuth") },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(implementation = RentalRequestDTO.class)
                    )
            )
    )
    @Parameters({
            @Parameter(
                    name = "Authorization", description = "Bearer Token", required = true
            )
    })
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    content = { @Content(schema = @Schema(implementation = RentalMsgResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "401",
                    content = { @Content(schema = @Schema()) })
    })
    @PostMapping(value = "", consumes = "multipart/form-data")
    public ResponseEntity<RentalMsgResponseDTO> createRental(@Valid @ModelAttribute RentalRequestDTO rentalRequestDTO) {
        RentalMsgResponseDTO response = rentalService.createRental(rentalRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * PUT /rentals/{id} => Mettre à jour une location
     * @param id
     * @param rentalRequestDTO
     * @return
     */
    @Operation(
            summary = "Mettre à jour une location",
            description = "Met à jour les informations d'une location existante.",
            security = { @SecurityRequirement(name = "bearerAuth") },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(implementation = RentalRequestDTO.class)
                    )
            )
    )
    @Parameters({
            @Parameter(
                    name = "Authorization", description = "Bearer Token", required = true
            )
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = RentalMsgResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "401",
                    content = { @Content(schema = @Schema()) })
    })
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<RentalMsgResponseDTO> updateRental(@PathVariable Integer id, @Valid @ModelAttribute RentalRequestDTO rentalRequestDTO) {
        RentalMsgResponseDTO response = rentalService.updateRental(id, rentalRequestDTO);

        return ResponseEntity.ok(response);
    }


}
