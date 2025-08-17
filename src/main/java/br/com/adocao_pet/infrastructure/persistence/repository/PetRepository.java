package br.com.adocao_pet.infrastructure.persistence.repository;

import br.com.adocao_pet.infrastructure.persistence.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
}
