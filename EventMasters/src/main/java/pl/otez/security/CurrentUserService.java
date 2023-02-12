package pl.otez.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.otez.user.client.ClientEntity;
import pl.otez.user.client.ClientRepository;
import pl.otez.user.employee.EmployeeEntity;
import pl.otez.user.employee.EmployeeRepository;
import pl.otez.user.validation.EmailValidator;

@Service
public class CurrentUserService implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public CurrentUserService(ClientRepository aClientRepository, EmployeeRepository aEmployeeRepository) {
        clientRepository = aClientRepository;
        employeeRepository = aEmployeeRepository;
    }

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        final ClientEntity client = clientRepository.findClientByEmail(new EmailValidator(username));
        if(client != null){
            final CurrentUser currentUser = new CurrentUser();

            currentUser.setUsername(client.getEmail().toString());
            currentUser.setPassword(client.getPassword().toString());

            return currentUser;
        }
        final EmployeeEntity employee = employeeRepository.findEmployeeByEmail(new EmailValidator(username));
        if(employee != null){
            final CurrentUser currentUser = new CurrentUser();

            currentUser.setUsername(employee.getEmail().toString());
            currentUser.setPassword(employee.getPassword().toString());

            return currentUser;
        } else {
            throw new UsernameNotFoundException("User with email: " + username + " does not exist!");
        }
    }
}
