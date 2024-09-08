package br.com.adocao_pet.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private BreedEntity breed;

    public PetEntity(String name, BreedEntity breed) {
        this.name = name;
        this.breed = breed;
    }
}
