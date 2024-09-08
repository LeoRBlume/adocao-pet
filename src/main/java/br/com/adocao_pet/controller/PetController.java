package br.com.adocao_pet.controller;

import br.com.adocao_pet.infrastructure.forms.PetForm;
import br.com.adocao_pet.infrastructure.records.PetRecord;
import br.com.adocao_pet.infrastructure.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping
    public PetRecord createPet(@RequestBody PetForm pet) {
        return petService.savePet(pet);
    }

    @GetMapping("/{id}")
    public PetRecord getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @GetMapping
    public List<PetRecord> getAllPets() {
        return petService.getAllPets();
    }

}
