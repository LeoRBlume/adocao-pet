package br.com.adocao_pet.infrastructure.persistence.entity;

import br.com.adocao_pet.infrastructure.forms.BreedForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class BreedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;

    public BreedEntity(String name, String description, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public static BreedEntity of(BreedForm breedForm) {
        return new BreedEntity(breedForm.getName(), breedForm.getDescription(), LocalDateTime.now());
    }

}
