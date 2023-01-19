package pl.otez.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.otez.user.employee.dto.EmployeeRequestDto;
import pl.otez.user.employee.position.PositionRepository;
import pl.otez.user.validation.EmailValidator;

@Component
@RequiredArgsConstructor
public class EmployeeWebMapper { //TODO fill EmployeeMapper with map methods
    private final PositionRepository positionRepository;


    EmployeeEntity fromEmployeeRequestDtoToEmployeeEntity(EmployeeRequestDto aEmployee) {
        return EmployeeEntity.builder()
                .aEmail(new EmailValidator(aEmployee.email()))
                .aFirstName(aEmployee.firstName())
                .aLastName(aEmployee.lastName())
                .aPassword(aEmployee.password())
                .aPosition(positionRepository.findPositionEntityById(aEmployee.positionId()))
                .build();
    }
}
