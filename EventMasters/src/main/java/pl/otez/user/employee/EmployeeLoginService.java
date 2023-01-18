package pl.otez.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.otez.security.SessionRegistry;
import pl.otez.user.ErrorsListDto;
import pl.otez.user.employee.dto.EmployeeLoginDto;
import pl.otez.user.employee.dto.EmployeeLoginResponseDto;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EmployeeLoginService {
    private final AuthenticationManager authenticationManager;
    private final SessionRegistry sessionRegistry;

    public EmployeeLoginResponseDto login(EmployeeLoginDto employee) {
        EmployeeLoginResponseDto responseDto = new EmployeeLoginResponseDto(new ErrorsListDto(new ArrayList<>()));
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employee.getEmail(), employee.getPassword()));
            final String sessionId = sessionRegistry.registerSession(employee.getEmail());
            responseDto.setSessionId(sessionId);
        } catch (BadCredentialsException | InternalAuthenticationServiceException aAuthenticationException) {
            if(!emailContainsAtSign(employee.getEmail())){
                responseDto.addToErrorList("Email must contain an '@' sign!");
            }
            responseDto.addToErrorList("You have entered bad credentials!");
        }
        return responseDto;
    }

    public Boolean emailContainsAtSign(String email){
        return email != null && email.contains("@");
    }

}
