package br.com.adocao_pet.infrastructure.service;

import br.com.adocao_pet.infrastructure.exception.NotFoundException;
import br.com.adocao_pet.infrastructure.forms.PetForm;
import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import br.com.adocao_pet.infrastructure.persistence.entity.PetEntity;
import br.com.adocao_pet.infrastructure.persistence.repository.PetRepository;
import br.com.adocao_pet.infrastructure.records.PetRecord;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private static Logger logger = LoggerFactory.getLogger(PetService.class);
    private final PetRepository petRepository;
    private final BreedService breedService;

    public PetRecord savePet(PetForm petForm) {
        logger.info("Received request to add a new pet with name: {}", petForm.getName());

        BreedEntity breed = breedService.getBreedEntityById(petForm.getBreedId()); // Buscando a raça pelo ID

        PetEntity pet = petForm.toPet(breed); // Convertendo o Form para a entidade Pet
        return PetRecord.of(petRepository.save(pet)); // Retornando o record diretamente
    }

    public PetRecord getPetById(Long id) {
        logger.info("Request to find pet by ID: {}", id);
        PetEntity petEntity = petRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Pet with ID {} not found", id);
                    return new NotFoundException("Pet with ID " + id + " not found.");
                });

        return PetRecord.of(petEntity);
    }

    public List<PetRecord> getAllPets() {
        return petRepository.findAll()
                .stream()
                .map(PetRecord::of)
                .toList();
    }
}
