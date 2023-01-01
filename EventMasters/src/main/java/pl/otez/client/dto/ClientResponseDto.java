package pl.otez.client.dto;

import lombok.Builder;

import java.time.LocalDate;
//TODO GET or POST?
public record ClientResponseDto(String email, String first_name, String last_name,
        String phone_number, String address, String password, LocalDate created_time,
        String NIP, String name_of_company) {

    @Builder
    public ClientResponseDto { }
}
