package pl.otez.intermediarycompany;


import org.springframework.stereotype.Component;
import pl.otez.intermediarycompany.dto.IntermediaryCompanyResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IntermediaryCompanyMapper {
    public IntermediaryCompanyResponseDto fromIntermediaryCompanyEntityToIntermediaryCompanyResponseDto(IntermediaryCompanyEntity aIntermediaryCompanyEntity){
        return IntermediaryCompanyResponseDto.builder()
                .NIP(aIntermediaryCompanyEntity.getNIP())
                .name_of_company(aIntermediaryCompanyEntity.getName_of_company().getNameOfCompany())
                .type_Of_Service_id(aIntermediaryCompanyEntity.getTypeOfServiceId().getID())
                .build();
    }

    public List<IntermediaryCompanyResponseDto> fromIntermediaryCompanyEntityListToIntermediaryCompanyResponseDto(List<IntermediaryCompanyEntity> aIntermediaryCompanyEntity){
        return aIntermediaryCompanyEntity.stream().map(this::fromIntermediaryCompanyEntityToIntermediaryCompanyResponseDto).collect(Collectors.toList());
    }
}
