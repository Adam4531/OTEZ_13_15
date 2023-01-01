package pl.otez.client;

import org.springframework.stereotype.Component;
import pl.otez.client.dto.ClientRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientRequestDto fromClientEntityToClientRequestDto(ClientEntity aClientEntity){
        return ClientRequestDto.builder()
                .email(aClientEntity.getEmail())
                .firstName(aClientEntity.getFirstName())
                .lastName(aClientEntity.getLastName())
                .phoneNumber(aClientEntity.getPhoneNumber())
                .address(aClientEntity.getAddress())
                .createdTime(aClientEntity.getCreatedTime())
                .password(aClientEntity.getPassword())
                .NIP(aClientEntity.getPassword())
                .nameOfCompany(aClientEntity.getNameOfCompany())
                .build();
    }

    public List<ClientRequestDto> fromClientEntityListToClientRequestDtoList(List<ClientEntity> aClientEntity){
        return aClientEntity.stream().map(this::fromClientEntityToClientRequestDto).collect(Collectors.toList());
    }
}
