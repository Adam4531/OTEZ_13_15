package pl.otez.user.employee.dto;

import lombok.Builder;

public record EmployeeRequestDto(Long id, String firstName, String lastName, String position,String email, String password) {

    @Builder
    public EmployeeRequestDto {
    }
}
