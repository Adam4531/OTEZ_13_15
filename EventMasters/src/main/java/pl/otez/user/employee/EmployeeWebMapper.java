package pl.otez.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.otez.user.employee.dto.EmployeeRequestDto;
import pl.otez.user.employee.position.PositionRepository;
import pl.otez.user.validation.EmailValidator;
import pl.otez.user.validation.PasswordValidator;

@Component
@RequiredArgsConstructor
public class EmployeeWebMapper {
    private final PositionRepository positionRepository;


    EmployeeEntity fromEmployeeRequestDtoToEmployeeEntity(EmployeeRequestDto aEmployee) {
        return EmployeeEntity.builder()
                .aEmail(new EmailValidator(aEmployee.email()))
                .aFirstName(aEmployee.firstName())
                .aLastName(aEmployee.lastName())
                .aPassword(new PasswordValidator(aEmployee.password()))
                .aPosition(positionRepository.findPositionEntityById(aEmployee.positionId()))
                .build();
    }
}
