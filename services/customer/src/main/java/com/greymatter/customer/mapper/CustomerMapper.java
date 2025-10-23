package com.greymatter.customer.mapper;

import com.greymatter.customer.dto.CustomerRequest;
import com.greymatter.customer.dto.CustomerResponse;
import com.greymatter.customer.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequest customerRequest);
    CustomerResponse toDto(Customer customer);
    List<CustomerResponse> toDtoList(List<Customer> customers);
}
