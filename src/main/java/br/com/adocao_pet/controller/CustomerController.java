package br.com.adocao_pet.controller;

import br.com.adocao_pet.infrastructure.forms.CustomerForm;
import br.com.adocao_pet.infrastructure.records.CustomerRecord;
import br.com.adocao_pet.infrastructure.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create a new customer", description = "This endpoint allows you to create a new customer by providing name and address.")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRecord createCustomer(@RequestBody CustomerForm customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID", description = "Fetches the customer with the provided ID.")
    @ResponseStatus(HttpStatus.OK)
    public CustomerRecord getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    @Operation(summary = "Get all customers", description = "Fetches the customers.")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerRecord> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
