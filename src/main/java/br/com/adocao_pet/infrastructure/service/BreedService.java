package br.com.adocao_pet.infrastructure.service;

import br.com.adocao_pet.controller.BreedController;
import br.com.adocao_pet.infrastructure.dtos.BreedDTO;
import br.com.adocao_pet.infrastructure.exception.UnprocessableEntityException;
import br.com.adocao_pet.infrastructure.forms.BreedForm;
import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import br.com.adocao_pet.infrastructure.persistence.repository.BreedRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreedService {
    private static Logger logger = LoggerFactory.getLogger(BreedService.class);
    private final BreedRepository breedRepository;

    public BreedDTO addBreed(BreedForm breedForm) {
        Optional<BreedEntity> existingBreed = breedRepository.findByName(breedForm.getName());
        if (existingBreed.isPresent()) {
            throw new UnprocessableEntityException("A breed with the same name already exists.");
        }

        BreedEntity breedEntity = breedRepository.save(BreedEntity.of(breedForm));
        logger.info("Breed created successfully with ID: {}", breedEntity.getId());
        return BreedDTO.of(breedEntity);
    }


    public List<BreedDTO> listBreeds() {
        return null;
    }
}
