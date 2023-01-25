package pl.otez.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.otez.interfaces.UserValidator;
import pl.otez.user.ErrorsListDto;
import pl.otez.user.employee.dto.EmployeeRequestDto;
import pl.otez.user.validation.EmailValidator;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EmployeeRegistrationService implements UserValidator {

    private final EmployeeRepository employeeRepository;
    private final EmployeeWebMapper employeeWebMapper;

    ErrorsListDto register(EmployeeRequestDto aEmployee) {
        ErrorsListDto errorsListDto = new ErrorsListDto(new ArrayList<>());

        if(!emailContainsAtSign(aEmployee.email())){
            errorsListDto.add("Email must contain an '@' sign!");
        }
        if(!isEmailUnique(aEmployee.email())){
            errorsListDto.add("Employee with this email does already exist!");
        }
        if(!passwordIsValidLength(aEmployee.password())){
            errorsListDto.add("Password must be at least 8 chars long!"); //TODO password of user at least 8 chars
        }
        if(!loginIsValidLength(aEmployee.email())){
            errorsListDto.add("Email must be at least 5 chars long!");
        }
        if(!nameContainsValidSigns(aEmployee.firstName(), aEmployee.lastName())){
            errorsListDto.add("First name and second name must contain only letters");
        }
        if(errorsListDto.isListOfErrorsEmpty()){
            EmployeeEntity employeeEntity = employeeWebMapper.fromEmployeeRequestDtoToEmployeeEntity(aEmployee);
            employeeRepository.save(employeeEntity);
        }
        return errorsListDto;
    }

    public boolean isEmailUnique(String email){
        final EmployeeEntity employee = employeeRepository.findEmployeeByEmail(new EmailValidator(email));
        return employee == null;
    }
}
