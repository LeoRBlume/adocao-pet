package br.com.adocao_pet.infrastructure.dtos;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;

import java.io.Serializable;

public record BreedDTO(Long id, String name, String description) implements Serializable {
    public BreedDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static BreedDTO of(BreedEntity breedEntity) {
        return new BreedDTO(breedEntity.getId(), breedEntity.getName(), breedEntity.getDescription());
    }
}
