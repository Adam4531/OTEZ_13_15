package pl.otez.ticket;

import org.springframework.stereotype.Component;
import pl.otez.ticket.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketMapper {
    public TicketDto fromTicketEntityToTicketDto(TicketEntity aTicketEntity){
        return TicketDto.builder()
                .client(aTicketEntity.getClient())
                .pricePerUnit(aTicketEntity.getPricePerUnit().getPricePerUnit())
                .event(aTicketEntity.getEvent())
                .build();
    }
    public List<TicketDto> fromTicketEntityListToTicketDto(List<TicketEntity> aTicketEntity){
        return aTicketEntity.stream().map(this::fromTicketEntityToTicketDto).collect(Collectors.toList());
    }
}
