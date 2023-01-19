package pl.otez.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.otez.user.ErrorsListDto;
import pl.otez.user.employee.dto.EmployeeLoginDto;
import pl.otez.user.employee.dto.EmployeeLoginResponseDto;
import pl.otez.user.employee.dto.EmployeeRequestDto;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeWebController {

    private final EmployeeLoginService employeeLoginService;
    private final EmployeeRegistrationService employeeRegistrationService;

    @PostMapping(path = "/employee/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeLoginResponseDto> login(@RequestBody EmployeeLoginDto employee){
        return ResponseEntity.ok(employeeLoginService.login(employee));
    }

    @PostMapping("/employee/registration")
    public ErrorsListDto create(@RequestBody EmployeeRequestDto employee){
        return employeeRegistrationService.register(employee);
    }
}
