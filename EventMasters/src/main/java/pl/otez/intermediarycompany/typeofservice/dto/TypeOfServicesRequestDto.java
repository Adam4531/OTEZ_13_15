package pl.otez.intermediarycompany.typeofservice.dto;

import lombok.Builder;

public record TypeOfServicesRequestDto(Long ID, String name) {
    @Builder
    public TypeOfServicesRequestDto{}
}
