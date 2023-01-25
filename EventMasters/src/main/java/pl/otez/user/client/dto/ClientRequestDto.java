package pl.otez.user.client.dto;

import lombok.Builder;

import java.time.LocalDate;

public record ClientRequestDto(String email, String firstName, String lastName, String password) {

    @Builder
    public ClientRequestDto { }
}
