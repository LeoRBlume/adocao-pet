package br.com.adocao_pet.infrastructure.persistence.repository;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BreedRepository extends JpaRepository<BreedEntity, Long>, JpaSpecificationExecutor<BreedEntity> {
    Optional<BreedEntity> findByName(String name);

}
