package pl.otez.user.client;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.otez.security.SessionRegistry;
import pl.otez.user.ErrorsListDto;
import pl.otez.user.client.dto.ClientLoginDto;
import pl.otez.user.client.dto.ClientLoginResponseDto;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ClientLoginService {
    private final AuthenticationManager authenticationManager;
    private final SessionRegistry sessionRegistry;

    public ClientLoginResponseDto login(ClientLoginDto client){
        ClientLoginResponseDto response = new ClientLoginResponseDto(new ErrorsListDto(new ArrayList<>()));

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(client.getEmail(), client.getPassword()));
            final String sessionId = sessionRegistry.registerSession(client.getEmail());
            response.setSessionId(sessionId);
        } catch (BadCredentialsException | InternalAuthenticationServiceException aAuthenticationException){
            if(!emailContainsAtSign(client.getEmail())){
                response.addToErrorList("Email must contain an '@' sign!");
            }
            response.addToErrorList("You have entered bad credentials!");
        }
        return response;
    }

    public Boolean emailContainsAtSign(String email){
        return email != null && email.contains("@");
    }
}
