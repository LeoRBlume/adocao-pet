package br.com.adocao_pet.infrastructure.persistence.repository.specification;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BreedSpecification {

    private BreedSpecification() {
    }

    public static Specification<BreedEntity> hasName(String name) {
        return (Root<BreedEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (name == null || name.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("name"), name);
        };
    }

    public static Specification<BreedEntity> hasCreationDate(LocalDate creationDate) {
        return (Root<BreedEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (creationDate == null) {
                return criteriaBuilder.conjunction();
            }
            LocalDateTime startOfDay = creationDate.atStartOfDay();
            LocalDateTime endOfDay = creationDate.atTime(LocalTime.MAX);

            return criteriaBuilder.between(root.get("date"), startOfDay, endOfDay);
        };
    }
}
