package pl.otez.user.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.otez.user.employee.dto.EmployeeResponseDto;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeMapper aEmployeeMapper, EmployeeRepository aEmployeeRepository) {
        employeeMapper = aEmployeeMapper;
        employeeRepository = aEmployeeRepository;
    }


    List<EmployeeResponseDto> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
        return employeeMapper.fromEmployeeEntityListToEmployeeResponseDtoList(employees);
    }

    public EmployeeEntity findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee with id:" + id + " does not exist!"));
    }

    public EmployeeResponseDto getEmployeeById(Long aId) {
        EmployeeEntity employeeEntity = findEmployeeById(aId);
        return employeeMapper.fromEmployeeEntityToEmployeeResponseDto(employeeEntity);
    }

    public String deleteEmployeeById(Long aId) {
        EmployeeEntity employeeEntity = findEmployeeById(aId);
        employeeRepository.delete(employeeEntity);
        return "Employee with id:" + aId + " has been successfully deleted!";

    }
}
