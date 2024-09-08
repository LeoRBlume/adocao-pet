package br.com.adocao_pet.infrastructure.forms;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import br.com.adocao_pet.infrastructure.persistence.entity.PetEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PetForm {
    private String name;
    private Long breedId;

    public PetEntity toPet(BreedEntity breedEntity) {
        return new PetEntity(this.name, breedEntity);
    }
}
