package br.com.adocao_pet.infrastructure.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@NoArgsConstructor
@Setter
public class AddressEntity {
    private String postalCode;
    private String number;
}
