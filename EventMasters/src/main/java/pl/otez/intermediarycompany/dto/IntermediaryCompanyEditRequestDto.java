package pl.otez.intermediarycompany.dto;

import lombok.Builder;

public record IntermediaryCompanyEditRequestDto(String name_of_company) {
    @Builder
    public IntermediaryCompanyEditRequestDto{}
}
