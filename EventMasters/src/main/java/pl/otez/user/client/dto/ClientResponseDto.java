package pl.otez.user.client.dto;

import lombok.Builder;

import java.time.LocalDate;

public record ClientResponseDto(Long id, String email, String firstName, String lastName, String password) {

    @Builder
    public ClientResponseDto { }
}
