package br.com.adocao_pet.infrastructure.records;

import br.com.adocao_pet.infrastructure.persistence.entity.AddressEntity;

public record AddressRecord(String postalCode, String number) {
    public static AddressRecord of(AddressEntity address) {
        return new AddressRecord(address.getPostalCode(), address.getNumber());
    }
}
