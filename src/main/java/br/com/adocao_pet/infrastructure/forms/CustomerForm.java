package br.com.adocao_pet.infrastructure.forms;

import br.com.adocao_pet.infrastructure.persistence.entity.AddressEntity;
import br.com.adocao_pet.infrastructure.persistence.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class CustomerForm {
    private String name;
    private String postalCode;
    private String number;

    public CustomerEntity toEntity() {
        AddressEntity address = new AddressEntity();
        address.setPostalCode(this.postalCode);
        address.setNumber(this.number);

        CustomerEntity customer = new CustomerEntity();
        customer.setName(this.name);
        customer.setAddress(address);
        return customer;
    }
}
