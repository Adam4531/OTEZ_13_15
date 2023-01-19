package pl.otez.user.client;

import org.springframework.stereotype.Component;
import pl.otez.user.client.dto.ClientRequestDto;
import pl.otez.user.validation.EmailValidator;

@Component
public class ClientWebMapper {
    ClientEntity fromClientRequestDtoToClientEntity(ClientRequestDto aClientRequestDto) { //FIXME
        return ClientEntity.builder()
                .aFirstName(aClientRequestDto.firstName())
                .aLastName(aClientRequestDto.lastName())
                .aAddress(aClientRequestDto.address())
                .aCreatedTime(aClientRequestDto.createdTime())
                .aEmail(new EmailValidator(aClientRequestDto.email()))
                .aNameOfCompany(aClientRequestDto.nameOfCompany())
                .aNIP(aClientRequestDto.NIP())
                .aPassword(aClientRequestDto.password())
                .aPhoneNumber(aClientRequestDto.phoneNumber())
                .build();
    }
}
