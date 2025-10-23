package com.greymatter.customer.service;

import com.greymatter.customer.dto.CustomerRequest;
import com.greymatter.customer.dto.CustomerResponse;
import com.greymatter.customer.exception.CustomerNotFoundException;
import com.greymatter.customer.mapper.CustomerMapper;
import com.greymatter.customer.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        var customer = this.customerRepository.save(customerMapper.toEntity(request));
        return customer.getId();
    }

    public List<CustomerResponse> findAllCustomers() {
        var customers = this.customerRepository.findAll();
        return customerMapper.toDtoList(customers);
    }

    public void updateCustomer(CustomerRequest request) {
        this.customerRepository.findById(request.id())
                .map(customer ->customerMapper.toEntity(request))
                .map(entity -> this.customerRepository.save(entity))
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id())
                ));
    }

    public CustomerResponse findById(String id) {
        return this.customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id)));
    }

    public boolean existsById(String id) {
        return this.customerRepository.findById(id)
                .isPresent();
    }

    public void deleteCustomer(String id) {
        this.customerRepository.deleteById(id);
    }
}
