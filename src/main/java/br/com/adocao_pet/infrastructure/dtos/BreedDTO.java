package br.com.adocao_pet.infrastructure.dtos;

import java.io.Serializable;
import java.util.UUID;

public record BreedDTO(UUID id, String name) implements Serializable {
    public BreedDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
