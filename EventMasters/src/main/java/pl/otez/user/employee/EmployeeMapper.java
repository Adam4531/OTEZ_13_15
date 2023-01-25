package pl.otez.user.employee;

import org.springframework.stereotype.Component;
import pl.otez.user.employee.dto.EmployeeResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public EmployeeResponseDto fromEmployeeEntityToEmployeeResponseDto(EmployeeEntity aEmployeeEntity) {
        return EmployeeResponseDto.builder()
                .id(aEmployeeEntity.getId())
                .email(aEmployeeEntity.getEmail().toString())
                .firstName(aEmployeeEntity.getFirstName())
                .lastName(aEmployeeEntity.getLastName())
                .password(aEmployeeEntity.getPassword().toString())
                .position(aEmployeeEntity.getPosition().getPosition())
                .build();
    }

    public List<EmployeeResponseDto> fromEmployeeEntityListToEmployeeResponseDtoList(List<EmployeeEntity> aEmployees) {
        return aEmployees.stream().map(this::fromEmployeeEntityToEmployeeResponseDto).collect(Collectors.toList());
    }
}
