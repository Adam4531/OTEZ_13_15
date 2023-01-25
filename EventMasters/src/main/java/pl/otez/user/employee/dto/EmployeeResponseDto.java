package pl.otez.user.employee.dto;

import lombok.Builder;

public record EmployeeResponseDto (Long id, String firstName, String lastName, String position, String password, String email){

    @Builder
    public EmployeeResponseDto {
    }
}
