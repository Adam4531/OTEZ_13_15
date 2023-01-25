package pl.otez.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.otez.user.validation.EmailValidator;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findEmployeeByEmail(EmailValidator aUsername);
}
