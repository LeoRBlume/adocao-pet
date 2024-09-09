package br.com.adocao_pet.infrastructure.records;

import br.com.adocao_pet.infrastructure.persistence.entity.CustomerEntity;

public record CustomerRecord(Long id, String name, AddressRecord address) {

    public static CustomerRecord of(CustomerEntity customer) {

        return new CustomerRecord(customer.getId(), customer.getName(), AddressRecord.of(customer.getAddress()));
    }
}
