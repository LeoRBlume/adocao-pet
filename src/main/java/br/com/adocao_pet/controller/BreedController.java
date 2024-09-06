package br.com.adocao_pet.controller;

import br.com.adocao_pet.infrastructure.dtos.BreedDTO;
import br.com.adocao_pet.infrastructure.forms.BreedForm;
import br.com.adocao_pet.infrastructure.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breeds")
@RequiredArgsConstructor
public class BreedController {
    private final BreedService breedService;

    @PostMapping
    @CacheEvict(value = "breedLists", allEntries = true)
    public BreedDTO addBreed(@RequestBody BreedForm breedForm) {
        return breedService.addBreed(breedForm);
    }

    @GetMapping
    @Cacheable(value = "breedLists")
    public List<BreedDTO> listBreeds() {
        return breedService.listBreeds();
    }
}
