package br.com.adocao_pet.controller;

import br.com.adocao_pet.infrastructure.forms.PetForm;
import br.com.adocao_pet.infrastructure.records.PetRecord;
import br.com.adocao_pet.infrastructure.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new pet", description = "This endpoint allows you to create a new pet.")
    public PetRecord createPet(@RequestBody @Validated PetForm pet) {
        return petService.savePet(pet);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get pet by ID", description = "Fetches the customer with the provided ID.")
    public PetRecord getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all pets", description = "Fetches the pets.")
    public List<PetRecord> getAllPets() {
        return petService.getAllPets();
    }

}
