package br.com.adocao_pet.controller;

import br.com.adocao_pet.infrastructure.forms.CustomerForm;
import br.com.adocao_pet.infrastructure.records.CustomerRecord;
import br.com.adocao_pet.infrastructure.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRecord createCustomer(@RequestBody CustomerForm customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerRecord getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerRecord> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
