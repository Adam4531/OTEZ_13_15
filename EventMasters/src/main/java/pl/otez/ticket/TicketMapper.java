package pl.otez.ticket;

import org.springframework.stereotype.Component;
import pl.otez.ticket.dto.TicketResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketMapper {
    public TicketResponseDto fromTicketEntityToTicketResponseDto(TicketEntity aTicketEntity){
        return TicketResponseDto.builder()
                .client_id(aTicketEntity.getClient_id())
                .price_per_unit(aTicketEntity.getPricePerUnit().getPricePerUnit())
                .event_id(aTicketEntity.getEvent_id())
                .build();
    }
    public List<TicketResponseDto> fromTicketEntityListToTicketResponseDto(List<TicketEntity> aTicketEntity){
        return aTicketEntity.stream().map(this::fromTicketEntityToTicketResponseDto).collect(Collectors.toList());
    }
}
