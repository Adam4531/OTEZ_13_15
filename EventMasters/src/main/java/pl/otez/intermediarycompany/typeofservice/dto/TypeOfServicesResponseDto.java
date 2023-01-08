package pl.otez.intermediarycompany.typeofservice.dto;

import lombok.Builder;

public record TypeOfServicesResponseDto(Long ID, String name) {
    @Builder
    public TypeOfServicesResponseDto{}

}
