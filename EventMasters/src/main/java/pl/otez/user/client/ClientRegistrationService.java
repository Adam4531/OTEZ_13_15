package pl.otez.user.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.otez.interfaces.UserValidator;
import pl.otez.user.ErrorsListDto;
import pl.otez.user.client.dto.ClientRequestDto;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ClientRegistrationService implements UserValidator {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ErrorsListDto register(ClientRequestDto aClientRequestDto){
        ErrorsListDto errorsListDto = new ErrorsListDto(new ArrayList<>());

        if ( !emailContainsAtSign(aClientRequestDto.email()) ) {
            errorsListDto.add("Email must contains '@' sign!");
        }
        if ( !isEmailUnique(aClientRequestDto.email()) ) {
            errorsListDto.add("User with this email already exists!");
        }
        if ( !passwordIsValidLength(aClientRequestDto.password()) ) {
            errorsListDto.add("Password must be at least 6 chars long!");
        }
        if ( !loginIsValidLength(aClientRequestDto.email()) ) {
            errorsListDto.add("Login must be at least 5 chars long!");
        }
        if ( !nameContainsValidSigns(aClientRequestDto.firstName(), aClientRequestDto.lastName()) ) {
            errorsListDto.add("First name and second name must contains only letters!");
        }
        if(errorsListDto.isListOfErrorsEmpty()){
            ClientEntity clientEntity = clientMapper.fromClientRequestDtoToClientEntity(aClientRequestDto);
            clientRepository.save(clientEntity);
        }
        return errorsListDto;
    }

    public boolean isEmailUnique(String email){
        final ClientEntity client = clientRepository.findClientByEmail(email);
        return client == null;
    }

}
