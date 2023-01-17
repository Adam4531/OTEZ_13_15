package pl.otez.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.otez.user.client.ClientEntity;
import pl.otez.user.client.ClientRepository;
import pl.otez.user.employee.EmployeeEntity;
import pl.otez.user.employee.EmployeeRepository;

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
        final ClientEntity client = clientRepository.findClientByEmail(username);
        if(client != null){
            final CurrentUser currentUser = new CurrentUser();

            currentUser.setUsername(client.getEmail().toString());
            currentUser.setPassword(client.getPassword());
        }
        final EmployeeEntity employee = employeeRepository.findEmployeeByEmail(username);
        if(employee != null){
            final CurrentUser currentUser = new CurrentUser();

            currentUser.setUsername(employee.getEmail());
            currentUser.setPassword(employee.getPassword());

            return currentUser;
        } else {
            throw new UsernameNotFoundException("User with email: " + username + " does not exist!");
        }
    }
}
