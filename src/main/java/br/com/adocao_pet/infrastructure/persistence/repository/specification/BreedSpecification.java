package br.com.adocao_pet.infrastructure.persistence.repository.specification;

import br.com.adocao_pet.infrastructure.persistence.entity.BreedEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BreedSpecification {
    private static final Logger logger = LoggerFactory.getLogger(BreedSpecification.class);


    public static Specification<BreedEntity> hasName(String name) {
        return (Root<BreedEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (name == null || name.isEmpty()) {
                logger.debug("Filtering by name: no filter applied.");
                return criteriaBuilder.conjunction();
            }
            logger.debug("Filtering by name: {}", name);
            return criteriaBuilder.equal(root.get("name"), name);
        };
    }

    public static Specification<BreedEntity> hasCreationDate(LocalDate creationDate) {
        return (Root<BreedEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (creationDate == null) {
                logger.debug("Filtering by creationDate: no filter applied.");
                return criteriaBuilder.conjunction();
            }
            LocalDateTime startOfDay = creationDate.atStartOfDay();
            LocalDateTime endOfDay = creationDate.atTime(LocalTime.MAX);

            logger.debug("Filtering by creationDate: between {} and {}", startOfDay, endOfDay);
            return criteriaBuilder.between(root.get("date"), startOfDay, endOfDay);
        };
    }
}
