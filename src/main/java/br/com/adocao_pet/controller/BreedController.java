package br.com.adocao_pet.controller;

import br.com.adocao_pet.infrastructure.dtos.BreedDTO;
import br.com.adocao_pet.infrastructure.forms.BreedForm;
import br.com.adocao_pet.infrastructure.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breeds")
@RequiredArgsConstructor
public class BreedController {
    private static Logger logger = LoggerFactory.getLogger(BreedController.class);
    private final BreedService breedService;

    @PostMapping
    @CacheEvict(value = "breedLists", allEntries = true)
    public BreedDTO addBreed(@RequestBody @Validated BreedForm breedForm) {
        logger.info("Received request to add a new breed with name: {}", breedForm.getName());
        return breedService.addBreed(breedForm);
    }

    @GetMapping
    public List<BreedDTO> listBreeds() {
        logger.info("Log teste");
        return breedService.listBreeds();
    }
}
