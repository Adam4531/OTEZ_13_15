package pl.otez.user.client.dto;

import lombok.Builder;

import java.time.LocalDate;
//POST
public record ClientResponseDto(String email, String firstName, String lastName,
        String phoneNumber, String address, String password, LocalDate createdTime,
        String NIP, String nameOfCompany) {

    @Builder
    public ClientResponseDto { }
}
