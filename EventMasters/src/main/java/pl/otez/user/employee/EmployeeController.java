package pl.otez.user.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.otez.user.client.ClientEditService;
import pl.otez.user.client.ClientService;
import pl.otez.user.client.dto.ClientResponseDto;
import pl.otez.user.employee.dto.EmployeeResponseDto;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController { //TODO fill it without endpoints to login and register

    private final EmployeeEditService employeeEditService;

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeEditService aEmployeeEditService, EmployeeService aEmployeeService) {
        employeeEditService = aEmployeeEditService;
        employeeService = aEmployeeService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponseDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponseDto getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployeeById(@RequestParam Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
