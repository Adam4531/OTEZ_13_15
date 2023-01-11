package pl.otez.ticket.dto;

import lombok.Builder;

import java.math.BigDecimal;

public record TicketRequestDto(Long id, Long client_id, BigDecimal price_per_unit, Long event_id) {
    @Builder
    public TicketRequestDto{}
}
