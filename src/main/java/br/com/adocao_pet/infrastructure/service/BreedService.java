package br.com.adocao_pet.infrastructure.service;

import br.com.adocao_pet.infrastructure.dtos.BreedDTO;
import br.com.adocao_pet.infrastructure.exception.NotFoundException;
import br.com.adocao_pet.infrastructure.exception.UnprocessableEntityException;
import br.com.adocao_pet.infrastructure.forms.BreedForm;
import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import br.com.adocao_pet.infrastructure.persistence.repository.BreedRepository;
import br.com.adocao_pet.infrastructure.persistence.repository.specification.BreedSpecification;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreedService {
    private static Logger logger = LoggerFactory.getLogger(BreedService.class);
    private final BreedRepository breedRepository;

    public BreedDTO addBreed(BreedForm breedForm) {
        logger.info("Received request to add a new breed with name: {}", breedForm.getName());

        Optional<BreedEntity> existingBreed = breedRepository.findByName(breedForm.getName());
        if (existingBreed.isPresent()) {
            throw new UnprocessableEntityException("A breed with the same name already exists.");
        }

        BreedEntity breedEntity = breedRepository.save(BreedEntity.of(breedForm));
        logger.info("Breed created successfully with ID: {}", breedEntity.getId());
        return BreedDTO.of(breedEntity);
    }


    public List<BreedDTO> listBreeds(String name, LocalDate creationDate) {
        logger.info("Request received to list all breeds");

        var spec = BreedSpecification.hasName(name)
                .and(BreedSpecification.hasCreationDate(creationDate));


        return breedRepository.findAll(spec).stream().map((BreedDTO::of)).toList();
    }

    public BreedDTO findById(Long id) {
        logger.info("Request to find breed by ID: {}", id);
        BreedEntity breed = breedRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Breed with ID {} not found", id);
                    return new NotFoundException("Breed with ID " + id + " not found.");
                });

        return BreedDTO.of(breed);
    }
}
