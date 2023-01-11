package pl.otez.intermediarycompany.dto;

import lombok.Builder;

public record IntermediaryCompanyRequestDto(String NIP, String name_of_company, Long type_Of_Service_id) {
    @Builder
    public IntermediaryCompanyRequestDto{

    }
}
