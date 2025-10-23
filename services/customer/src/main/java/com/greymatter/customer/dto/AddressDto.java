package com.greymatter.customer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;


@Validated
public record AddressDto(
        @NotNull(message = "Address street is required")
        String street,
        @NotNull(message = "Address houseNumber is required")
        String houseNumber,
        @NotNull(message = "Address zipCode is required")
        String zipCode) {
}


/*
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class AddressDto {
    @NotNull(message = "Address Street is required")
    private String street;
    @NotNull(message = "houseNumber Street is required")
    private String houseNumber;
    @NotNull(message = "zipCode Street is required")
    private String zipCode;
}*/
