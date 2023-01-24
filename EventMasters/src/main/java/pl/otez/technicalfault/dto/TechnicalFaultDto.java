package pl.otez.technicalfault.dto;

import lombok.Builder;

public record TechnicalFaultDto(Long id, Long type_of_fault_id, String description, String status, Long employee_id) {

    @Builder
    public TechnicalFaultDto {
    }
}
