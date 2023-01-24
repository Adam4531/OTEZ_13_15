package pl.otez.technicalfault;

import org.springframework.stereotype.Component;
import pl.otez.technicalfault.dto.TechnicalFaultDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TechnicalFaultMapper {

    public TechnicalFaultDto fromTechnicalFaultEntityToTechnicalFaultDto(TechnicalFaultEntity aTechnicalFaultEntity){
        return TechnicalFaultDto.builder()
                .id(aTechnicalFaultEntity.getId())
                .description(aTechnicalFaultEntity.getDescription())
                .employee_id(aTechnicalFaultEntity.getEmployee().getId())
                .status(aTechnicalFaultEntity.getStatus().toString())
                .type_of_fault_id(aTechnicalFaultEntity.getTypeOfFault().getId())
                .build();
    }

    public List<TechnicalFaultDto> fromTechnicalFaultEntityListToTechnicalFaultDtoList(List<TechnicalFaultEntity> aTechnicalFaultEntityList){
        return aTechnicalFaultEntityList.stream().map(this::fromTechnicalFaultEntityToTechnicalFaultDto).collect(Collectors.toList());
    }
}
