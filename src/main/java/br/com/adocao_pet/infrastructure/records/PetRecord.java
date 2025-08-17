package br.com.adocao_pet.infrastructure.records;

import br.com.adocao_pet.infrastructure.persistence.entity.PetEntity;

public record PetRecord(Long id, String name, BreedRecord breed) {
    public static PetRecord of(PetEntity pet) {
        return new PetRecord(pet.getId(), pet.getName(), BreedRecord.of(pet.getBreed()));
    }
}
