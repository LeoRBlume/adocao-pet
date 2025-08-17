package br.com.adocao_pet.infrastructure.records;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;

import java.io.Serializable;

public record BreedRecord(Long id, String name, String description) implements Serializable {
    public BreedRecord(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static BreedRecord of(BreedEntity breedEntity) {
        return new BreedRecord(breedEntity.getId(), breedEntity.getName(), breedEntity.getDescription());
    }
}
