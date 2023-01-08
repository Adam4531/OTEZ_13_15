package pl.otez.intermediarycompany.typeofservice.dto;

import lombok.Builder;

public record TypeOfServicesEditRequestDto(String name){
    @Builder
    public TypeOfServicesEditRequestDto{}
}
