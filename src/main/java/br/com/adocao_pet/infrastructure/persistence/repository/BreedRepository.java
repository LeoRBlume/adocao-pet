package br.com.adocao_pet.infrastructure.persistence.repository;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<BreedEntity, Long> {
}
