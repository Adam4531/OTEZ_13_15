package pl.otez.client.dto;

import lombok.Builder;

import java.time.LocalDate;

//TODO GET or POST?
public record ClientRequestDto(String email, String firstName, String lastName, String phoneNumber,
                               String address, LocalDate createdTime, String password, String NIP,
                               String nameOfCompany) {

    @Builder
    public ClientRequestDto { }
}
