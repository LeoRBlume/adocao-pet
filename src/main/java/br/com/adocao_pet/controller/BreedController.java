package br.com.adocao_pet.controller;

import br.com.adocao_pet.infrastructure.dtos.BreedDTO;
import br.com.adocao_pet.infrastructure.forms.BreedForm;
import br.com.adocao_pet.infrastructure.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/breeds")
@RequiredArgsConstructor
public class BreedController {

    private final BreedService breedService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value = "breedLists", allEntries = true)
    public BreedDTO addBreed(@RequestBody @Validated BreedForm breedForm) {
        return breedService.addBreed(breedForm);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BreedDTO findById(@PathVariable Long id) {
        return breedService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Cacheable(value = "breedLists")
    public List<BreedDTO> listAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDate creationDate) {
        return breedService.listBreeds(name, creationDate);
    }
}
