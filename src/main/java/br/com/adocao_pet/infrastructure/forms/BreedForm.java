package br.com.adocao_pet.infrastructure.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class BreedForm {
    @NonNull
    private String name;
    @NonNull
    private String description;
}
