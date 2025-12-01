package com.ecommerce.user.dto;

import com.ecommerce.user.models.UserRole;
import lombok.Data;

@Data
public class AddressDto {

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    @Data
    public static class UserResponse {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private UserRole role=UserRole.CUSTOMER;
        private AddressDto address;

    }
}
