package br.com.adocao_pet.infrastructure.service;

import br.com.adocao_pet.infrastructure.exception.NotFoundException;
import br.com.adocao_pet.infrastructure.exception.UnprocessableEntityException;
import br.com.adocao_pet.infrastructure.forms.CustomerForm;
import br.com.adocao_pet.infrastructure.persistence.entity.CustomerEntity;
import br.com.adocao_pet.infrastructure.persistence.repository.BreedRepository;
import br.com.adocao_pet.infrastructure.persistence.repository.CustomerRepository;
import br.com.adocao_pet.infrastructure.records.CustomerRecord;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final BreedRepository breedRepository;

    public CustomerRecord saveCustomer(CustomerForm customerForm) {
        logger.info("Received request to add a new customer with name: {}", customerForm.getName());

        Optional<CustomerEntity> existingCustomer = customerRepository.findByName(customerForm.getName());
        if (existingCustomer.isPresent()) {
            throw new UnprocessableEntityException("A customer with the same name already exists.");
        }

        CustomerEntity customerEntity = customerRepository.save(customerForm.toEntity());
        logger.info("Customer created successfully with ID: {}", customerEntity.getId());
        return CustomerRecord.of(customerEntity);
    }

    public CustomerRecord getCustomerById(Long id) {
        logger.info("Request to find customer by ID: {}", id);
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Customer with ID {} not found", id);
                    return new NotFoundException("Customer with ID " + id + " not found.");
                });

        return CustomerRecord.of(customerEntity);
    }

    public List<CustomerRecord> getAllCustomers() {
        logger.info("Request received to list all customers");

        return customerRepository.findAll().stream().map((CustomerRecord::of)).toList();
    }
}
