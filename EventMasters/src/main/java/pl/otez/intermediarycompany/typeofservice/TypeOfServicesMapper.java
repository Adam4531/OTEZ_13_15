package pl.otez.intermediarycompany.typeofservice;

import org.springframework.stereotype.Component;
import pl.otez.intermediarycompany.typeofservice.dto.TypeOfServicesResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeOfServicesMapper {
    public TypeOfServicesResponseDto fromTypeOfServicesEntityToTypeOfServicesResponseDto(TypeOfServicesEntity aTypeOfServicesEntity){
        return TypeOfServicesResponseDto.builder().
                ID(aTypeOfServicesEntity.getID()).
                name(aTypeOfServicesEntity.getName().getName()).
                build();
    }

    public List<TypeOfServicesResponseDto> fromTypeOfServicesEntityListToTypeOfServicesResponseDto(List<TypeOfServicesEntity> aTypeOfServicesEntity){
        return aTypeOfServicesEntity.stream().map(this::fromTypeOfServicesEntityToTypeOfServicesResponseDto).collect(Collectors.toList());
    }
}
