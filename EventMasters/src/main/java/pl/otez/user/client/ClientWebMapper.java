package pl.otez.user.client;

import org.springframework.stereotype.Component;
import pl.otez.user.client.dto.ClientRequestDto;
import pl.otez.user.validation.EmailValidator;
import pl.otez.user.validation.PasswordValidator;

@Component
public class ClientWebMapper {
    ClientEntity fromClientRequestDtoToClientEntity(ClientRequestDto aClientRequestDto) {
        return ClientEntity.builder()
                .aFirstName(aClientRequestDto.firstName())
                .aLastName(aClientRequestDto.lastName())
                .aEmail(new EmailValidator(aClientRequestDto.email()))
                .aPassword(new PasswordValidator(aClientRequestDto.password()))
                .build();
    }
}
