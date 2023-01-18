package pl.otez.user.employee;

import org.springframework.stereotype.Component;
import pl.otez.user.employee.dto.EmployeeRequestDto;

@Component
public class EmployeeMapper { //TODO fill EmployeeMapper with map methods
    EmployeeEntity fromEmployeeRequestDtoToEmployeeEntity(EmployeeRequestDto aEmployee) {
        return new EmployeeEntity();
    }
}
