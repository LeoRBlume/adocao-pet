package br.com.adocao_pet.infrastructure.forms;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BreedForm {
    @NonNull
    private String name;
    @NonNull
    private String description;

    public BreedEntity toEntity() {
        return new BreedEntity(this.getName(), this.getDescription(), LocalDateTime.now());
    }
}
