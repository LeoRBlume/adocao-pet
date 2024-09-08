package br.com.adocao_pet.infrastructure.records;

import br.com.adocao_pet.infrastructure.persistence.entity.CustomerEntity;

import java.util.List;

public record CustomerRecord(Long id, String name, AddressRecord address, List<PetRecord> pets) {

    public static CustomerRecord of(CustomerEntity customer) {
        List<PetRecord> petRecords = customer.getPets().stream()
                .map(PetRecord::of)
                .toList();
        return new CustomerRecord(customer.getId(), customer.getName(), AddressRecord.of(customer.getAddress()), petRecords);
    }
}
