package pl.otez.user.client.dto;

import lombok.Builder;

public record ClientEditRequestDto(String email, String firstName, String lastName, String phoneNumber,
                                   String address, String password, String NIP,
                                   String nameOfCompany) {

    @Builder
    public ClientEditRequestDto {
    }
}
