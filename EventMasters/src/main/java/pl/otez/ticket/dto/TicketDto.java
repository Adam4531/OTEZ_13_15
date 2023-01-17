package pl.otez.ticket.dto;

import lombok.Builder;
import pl.otez.event.EventEntity;
import pl.otez.user.client.ClientEntity;

import java.math.BigDecimal;

public record TicketDto(Long id, ClientEntity client, BigDecimal pricePerUnit, EventEntity event){

    @Builder
    public TicketDto {}
}
