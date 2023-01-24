package pl.otez.user.client;

import org.springframework.stereotype.Component;
import pl.otez.user.client.dto.ClientRequestDto;
import pl.otez.user.client.dto.ClientResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientResponseDto fromClientEntityToClientResponseDto(ClientEntity aClientEntity){
        return ClientResponseDto.builder()
                .email(aClientEntity.getEmail().toString())
                .firstName(aClientEntity.getFirstName())
                .lastName(aClientEntity.getLastName())
                .phoneNumber(aClientEntity.getPhoneNumber())
                .address(aClientEntity.getAddress())
                .createdTime(aClientEntity.getCreatedTime())
                .password(aClientEntity.getPassword().toString())
                .NIP(aClientEntity.getNIP())
                .nameOfCompany(aClientEntity.getNameOfCompany())
                .build();
    }

    public List<ClientResponseDto> fromClientEntityListToClientResponseDtoList(List<ClientEntity> aClientEntity){
        return aClientEntity.stream().map(this::fromClientEntityToClientResponseDto).collect(Collectors.toList());
    }

}
